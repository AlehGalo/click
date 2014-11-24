Ext.define('AlfaClick.view.portal.WestMenu', {
    extend: 'Ext.panel.Panel',    
    
    alias: 'widget.westmenu',

    requires: [
        'AlfaClick.view.portal.NavigationMenu',
        'AlfaClick.view.portal.SettingsMenu'
    ],
    
    initComponent: function() {
        
        Ext.apply(this, {

            title: 'Options',
            animCollapse: true,
            width: 200,
            minWidth: 150,
            maxWidth: 400,
            split: true,
            collapsible: true,
            layout:{
                type: 'accordion',
                animate: true
            },
            items: [{
                xtype: 'navigation'
            },{
                xtype: 'settings'
            }]
        });
                
        this.callParent(arguments);
    }
});