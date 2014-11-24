Ext.define('AlfaClick.view.portal.PortletPanel', {
    extend: 'AlfaClick.view.app.PortalPanel',    
    
    alias: 'widget.portletpanel',

    uses: ['AlfaClick.util.Constants'],

    getTools: function(){
        return [{
            xtype: 'tool',
            type: 'gear',
            handler: function(e, target, panelHeader, tool){
                var portlet = panelHeader.ownerCt;
                portlet.setLoading('Loading...');
                Ext.defer(function() {
                    portlet.setLoading(false);
                }, 2000);
            }
        }];
    },
    
    initComponent: function() {
        
        Ext.apply(this, {

            items: [{
                id: 'col-1',
                items: [{
                    id: 'portlet-1',
                    title: 'Grid Portlet',
                    tools: this.getTools(),
                    items: Ext.create('AlfaClick.view.portlet.GridPortlet')
                },{
                    id: 'portlet-2',
                    title: 'Portlet 2',
                    tools: this.getTools(),
                    html: AlfaClick.util.Constants.shortBogusMarkup
                }]
            },{
                id: 'col-2',
                items: [{
                    id: 'portlet-3',
                    title: 'Portlet 3',
                    tools: this.getTools(),
                    html: AlfaClick.util.Constants.bogusMarkup
                }]
            },{
                id: 'col-3',
                items: [{
                    id: 'portlet-4',
                    title: 'Stock Portlet',
                    tools: this.getTools(),
                    items: Ext.create('AlfaClick.view.portlet.ChartPortlet')
                }]
            }]
            
        });
                
        this.callParent(arguments);
    }
});