define([
    'jquery',
    'underscore',
    'backbone',
    //Main template for this view
    'text!templates/home/second.html'
], function($, _, Backbone, homeSecondTemplate){

    return Backbone.View.extend({
        id: "home-view",
        template : _.template(homeSecondTemplate),
        initialize: function(){

            $("#loadingSplash").html(this.el);
            this.render();
        },
        render: function(){
            var self = this;
            var data = {};
            //We can add some data to the template here if needed
            self.$el.html( self.template( data ) );
        }
    });
});