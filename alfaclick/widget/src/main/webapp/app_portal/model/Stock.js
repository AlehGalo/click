Ext.define('AlfaClick.model.Stock', {
	extend: 'Ext.data.Model',
	fields: [
	    {name: 'company'},
        {name: 'change',     type: 'float'},
        {name: 'pctChange',  type: 'float'}
    ]
});