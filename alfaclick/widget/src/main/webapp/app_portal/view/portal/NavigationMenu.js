Ext.define('AlfaClick.view.portal.NavigationMenu', {
    extend: 'Ext.panel.Panel',    
    
    alias: 'widget.navigation',
    
    initComponent: function() {
        
        Ext.apply(this, {

            html: AlfaClick.util.Constants.shortBogusMarkup,
            title:'Navigation',
            autoScroll: true,
            border: false,
            iconCls: 'nav'
            
        });
                
        this.callParent(arguments);
    }
});