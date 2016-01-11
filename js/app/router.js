define([
	// Libraries to load
  'jquery',
  'underscore',
  'backbone',
  // Views to load
  'views/home/main',
  'views/home/second',
  'views/examples/list',
  'views/examples/detail'
], function($, _, Backbone, homeMainView, homeSecondView, exampleListView, exampleDetailView){
	// All of the dependencies in the array above become parameters of the function to be managed
	var AppRouter = Backbone.Router.extend({
		routes: {
			'examples': 'showExamples',
			'example/:id': 'showExample',
			'second' : 'second',
			// Default
			'*actions': 'defaultAction'
		},

		showExamples: function() {
			exampleListView.render();
		},
		showExample: function(id) {
			exampleDetailView.show(id);
		},
		second : function(){
			this.loadView(new homeSecondView());
		},
		defaultAction: function(actions) {
			this.loadView(new homeMainView());
		},

		loadView : function(view) {
			this.view && this.view.remove();
			this.view = view;
		}
	});

	var initialize = function(){
		var app_router = new AppRouter();
		Backbone.history.start();
	};

  return {
  	initialize: initialize
  };
});