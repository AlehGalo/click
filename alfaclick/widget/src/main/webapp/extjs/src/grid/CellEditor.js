/*
This file is part of Ext JS 4.2

Copyright (c) 2011-2013 Sencha Inc

Contact:  http://www.sencha.com/contact

GNU General Public License Usage
This file may be used under the terms of the GNU General Public License version 3.0 as
published by the Free Software Foundation and appearing in the file LICENSE included in the
packaging of this file.

Please review the following information to ensure the GNU General Public License version 3.0
requirements will be met: http://www.gnu.org/copyleft/gpl.html.

If you are unsure which license is appropriate for your use, please contact the sales department
at http://www.sencha.com/contact.

Build date: 2013-03-11 22:33:40 (aed16176e68b5e8aa1433452b12805c0ad913836)
*/
/**
 * Internal utility class that provides default configuration for cell editing.
 * @private
 */
Ext.define('Ext.grid.CellEditor', {
    extend: 'Ext.Editor',
    constructor: function(config) {
        config = Ext.apply({}, config);
        
        if (config.field) {
            config.field.monitorTab = false;
        }
        this.callParent([config]);
    },
    
    /**
     * @private
     * Hide the grid cell text when editor is shown.
     *
     * There are 2 reasons this needs to happen:
     *
     * 1. checkbox editor does not take up enough space to hide the underlying text.
     *
     * 2. When columnLines are turned off in browsers that don't support text-overflow:
     *    ellipsis (firefox 6 and below and IE quirks), the text extends to the last pixel
     *    in the cell, however the right border of the cell editor is always positioned 1px
     *    offset from the edge of the cell (to give it the appearance of being "inside" the
     *    cell.  This results in 1px of the underlying cell text being visible to the right
     *    of the cell editor if the text is not hidden.
     * 
     * We can't just hide the entire cell, because then treecolumn's icons would be hidden
     * as well.  We also can't just set "color: transparent" to hide the text because it is
     * not supported by IE8 and below.  The only remaining solution is to remove the text
     * from the text node and then add it back when the editor is hidden.
     */
    onShow: function() {
        var me = this,
            innerCell = me.boundEl.first(),
            treeNode,
            textNode;

        if (innerCell) {
            
            // Extract text bearing node.
            // TreeColumns have a .x-tree-node-text inline element (<a> or <span>)
            if (me.isForTree) {
                treeNode = innerCell.child('.' + Ext.baseCSSPrefix + 'tree-node-text', true);
                if (treeNode) {
                    textNode = treeNode.firstChild;
                }
            } else {
                textNode = innerCell.dom.lastChild;
            }

            if (textNode && textNode.nodeType === 3) {
                // if the cell has a text node, save a reference to it
                me.cellTextNode = textNode;
                // save the cell text so we can add it back when we're done editing
                me.cellTextValue = textNode.nodeValue;
                // The text node has to have at least one character in it, or the cell borders
                // in IE quirks mode will not show correctly, so let's use a non-breaking space.
                textNode.nodeValue = me.emptyText;
            }
        }
        me.callParent(arguments);
    },

    /**
     * @private
     * Show the grid cell text when the editor is hidden by adding the text back to the text node
     */
    onHide: function() {
        var me = this,
            innerCell = me.boundEl.first(),
            node = me.cellTextNode;

        if (innerCell && node) {
            // The value may have changed since we started, so only restore it
            // if the value is the same as our space we set earlier
            if (node.nodeValue == me.emptyText) {
                node.nodeValue = me.cellTextValue;
            }
            delete me.cellTextNode;
            delete me.cellTextValue;
        }
        me.callParent(arguments);
    },

    /**
     * @private
     * Fix checkbox blur when it is clicked.
     */
    afterRender: function() {
        var me = this,
            field = me.field;

        me.callParent(arguments);
        if (field.isXType('checkboxfield')) {
            field.mon(field.inputEl, {
                mousedown: me.onCheckBoxMouseDown,
                click: me.onCheckBoxClick,
                scope: me
            });
        }
    },
    
    /**
     * @private
     * Because when checkbox is clicked it loses focus  completeEdit is bypassed.
     */
    onCheckBoxMouseDown: function() {
        this.completeEdit = Ext.emptyFn;
    },
    
    /**
     * @private
     * Restore checkbox focus and completeEdit method.
     */
    onCheckBoxClick: function() {
        delete this.completeEdit;
        this.field.focus(false, 10);
    },
    
    /**
     * @private
     * Realigns the Editor to the grid cell, or to the text node in the grid inner cell
     * if the inner cell contains multiple child nodes.
     */
    realign: function(autoSize) {
        var me = this,
            boundEl = me.boundEl,
            innerCell = boundEl.first(),
            children = innerCell.dom.childNodes,
            childCount = children.length,
            offsets = Ext.Array.clone(me.offsets),
            textSpan, width;

        // If the inner cell has more than one child, or the first child node is not a text node,
        // let's assume this cell contains additional elements before the text node.
        // This is the case for tree cells, but could also be used to accomodate grid cells that
        // have a custom renderer that render, say, an icon followed by some text for example
        // For now however, this support will only be used for trees.
        if (me.isForTree && (childCount > 1 || (childCount === 1 && children[0].nodeType !== 3))) {
            // Get the inner cell's text bearing element
            textSpan = innerCell.child('.' + Ext.baseCSSPrefix + 'tree-node-text');
            // Calculate the left bound of the text node
            // set the editor's x offset to the left bound position
            offsets[0] = textSpan.getOffsetsTo(innerCell)[0];
            // calculate the right bound of the text node (this is assumed to be the right edge of
            // the inner cell, since we are assuming the text node is always the last node in the
            // inner cell)
            // Difference between right edge and text start..
            // this will be used as the width for the editor.
            width = innerCell.getWidth() - offsets[0];

            me.addCls(Ext.baseCSSPrefix + 'grid-cell-editor-on-text-node');
        } else {
            width = boundEl.getWidth() - 1;
        }

        if (autoSize === true) {
            me.field.setWidth(width);
        }

        me.alignTo(boundEl, me.alignment, offsets);
    },
    
    onEditorTab: function(e){
        var field = this.field;
        if (field.onEditorTab) {
            field.onEditorTab(e);
        }
    },
    
    emptyText: '\u00a0',

    alignment: "tl-tl",
    hideEl : false,
    cls: Ext.baseCSSPrefix + 'small-editor ' +
        Ext.baseCSSPrefix + 'grid-editor ' + 
        Ext.baseCSSPrefix + 'grid-cell-editor',
    shim: false,
    shadow: false
});