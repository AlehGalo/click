Ext.define('AlfaClick.view.Viewport', {

	extend : 'Ext.container.Viewport',
	requires : [ 'AlfaClick.view.portal.PortalPanel',
			'AlfaClick.view.portal.PortalColumn',
			'AlfaClick.view.portal.PortalDropZone',
			'AlfaClick.view.portal.Portlet',
			'AlfaClick.view.portal.GridPortlet',
			'AlfaClick.view.portal.ChartPortlet',
			'AlfaClick.view.portal.JSFPortlet' ],
	getTools : function() {
		return [ {
			xtype : 'tool',
			type : 'gear',
			handler : function(e, target, header, tool) {
				var portlet = header.ownerCt;
				portlet.setLoading('Загрузка ...');
				Ext.defer(function() {
					portlet.setLoading(false);
				}, 2000);
			}
		} ];
	},
	initComponent : function() {
		var content = '<div class="portlet-content">SAMPLE_CONTENT</div>';
		debugger;
		Ext.apply(this, {
			id : 'app-viewport',
			layout : {
				type : 'border',
				padding : '0 5 5 5' // pad the layout from the window edges
			},
			items : [ {
				id : 'app-header',
				xtype : 'box',
				region : 'north',
				height : 40,
				html : 'Alfa Click'
			}, {
				xtype : 'container',
				region : 'center',
				layout : 'border',
				items : [ {
					id : 'app-options',
					title : 'Options',
					region : 'west',
					// animCollapse: true,
					width : 200,
					minWidth : 150,
					maxWidth : 400,
					split : true,
				// collapsible: true,
				/*
				 * layout:{ type: 'accordion', animate: true },
				 */
				/*
				 * items: [{ html: content, title:'Navigation', autoScroll:
				 * true, border: false, iconCls: 'nav' },{ title:'Settings',
				 * html: content, border: false, autoScroll: true, iconCls:
				 * 'settings' }]
				 */
				}, {
					id : 'app-portal',
					collapsible : true,
					xtype : 'portalpanel',
					region : 'center',
				/*
				 * items: [{ id: 'col-1', items: [{ id: 'portlet-1', title:
				 * 'Grid Portlet', tools: this.getTools(), items:
				 * Ext.create('AlfaClick.view.portal.GridPortlet'), listeners: {
				 * 'close': Ext.bind(this.onPortletClose, this) } },{ id:
				 * 'portlet-2', title: 'Portlet 2', tools: this.getTools(),
				 * html: content, listeners: { 'close':
				 * Ext.bind(this.onPortletClose, this) } }] },{ id: 'col-2',
				 * items: [{ id: 'portlet-3', title: 'Portlet 3', tools:
				 * this.getTools(), html: '<div
				 * class="portlet-content">'+this.bogusMarkup+'</div>',
				 * listeners: { 'close': Ext.bind(this.onPortletClose, this) } }]
				 * },{ id: 'col-3', items: [{ id: 'portlet-4', title: 'Stock
				 * Portlet', tools: this.getTools(), items:
				 * Ext.create('AlfaClick.view.portal.ChartPortlet'), listeners: {
				 * 'close': Ext.bind(this.onPortletClose, this) } },{ id:
				 * 'portlet-5', title: 'Привет', tools: this.getTools(), html:
				 * content, listeners: { 'close': Ext.bind(this.onPortletClose,
				 * this) } }] },{ id: 'col-4', items: [{ id: 'portlet-33',
				 * title: 'Stock Portlet', tools: this.getTools(), items:
				 * Ext.create('AlfaClick.view.portal.ChartPortlet'), listeners: {
				 * 'close': Ext.bind(this.onPortletClose, this) } },{ id:
				 * 'portlet-54', title: 'Привет', tools: this.getTools(), html:
				 * content, listeners: { 'close': Ext.bind(this.onPortletClose,
				 * this) } }] }]
				 */
				} ]
			} ]
		});
		this.callParent(arguments);
	},

	onPortletClose : function(portlet) {
		this.showMsg('"' + portlet.title + '" was removed');
	},

	showMsg : function(msg) {
		var el = Ext.get('app-msg'), msgId = Ext.id();

		this.msgId = msgId;
		el.update(msg).show();

		Ext.defer(this.clearMsg, 3000, this, [ msgId ]);
	},

	clearMsg : function(msgId) {
		if (msgId === this.msgId) {
			Ext.get('app-msg').hide();
		}
	}
});