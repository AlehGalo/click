Ext.define('AlfaClick.view.Viewport', {

    extend: 'Ext.container.Viewport',
   
    uses: [
        'AlfaClick.view.app.PortalPanel', 
        'AlfaClick.view.app.PortalColumn',
        'AlfaClick.view.portal.PortletPanel',
        'AlfaClick.view.portal.WestMenu',
        'AlfaClick.view.portlet.GridPortlet', 
        'AlfaClick.view.portlet.ChartPortlet',
        'AlfaClick.util.Constants'
    ],

    initComponent: function(){

        Ext.apply(this, {
            id: 'app-viewport',
            layout: {
                type: 'border',
                padding: '0 5 5 5'
            },
            items: [{
                id: 'app-header',
                xtype: 'box',
                region: 'north',
                height: 40,
                html: 'Ext Portal'
            },{
                xtype: 'container',
                region: 'center',
                layout: 'border',
                items: [{
                    id: 'app-options',
                    xtype: 'westmenu',
                    region: 'west'
                },{
                    id: 'app-portal',
                    xtype: 'portletpanel',
                    region: 'center',
                }]
            }]
        });
        this.callParent(arguments);
    }
});