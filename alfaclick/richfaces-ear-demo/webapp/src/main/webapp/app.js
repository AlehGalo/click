Ext.Loader.setConfig({
	enabled : true
});
Ext.Loader.setPath('AlfaClick', 'app');
Ext.application({
	name : 'AlfaClick',
	requires : [ 'Ext.layout.container.*', 'Ext.resizer.Splitter',
			'Ext.fx.target.Element', 'Ext.fx.target.Component',
			'Ext.window.Window' ],
	launch : function() {
		Ext.create('AlfaClick.view.Viewport');
		var logo = Ext.get('loadingLogo');
		if (logo) {
			logo.remove();
		}
	}
});
