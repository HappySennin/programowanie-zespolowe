url = 'http://jsonplaceholder.typicode.com/posts';

function ViewModel () {
    var self = this;

    self.items = ko.observableArray([]);
    self.body = ko.observableArray([]);
    self.userId = ko.observableArray([]);
    self.id = ko.observableArray([]);
    self.lastPost = ko.observable(0);

    var lastPost = self.lastPost();
    var body = self.body();
    var userId = self.userId();
    var id = self.id();

    self.getObjects = function (number) {
        $.getJSON(url, function (data) {


            for (var i = lastPost; i < lastPost + number; i++){
                if(i< data.length) {
                    self.items.push(data[i]);


                }
                else {
                    break;
                }
            }
            if(data.length > lastPost) {
                lastPost += number;
                console.log(lastPost);
                console.log(self.items());
            }
        });
    }


    self.scrolled = function (data, event){
        var elem = event.target;
        if (elem.scrollTop > (elem.scrollHeight - elem.offsetHeight))
        {
            self.getObjects(10);

        }

    }

}

var viewModel = new ViewModel();
ko.applyBindings(viewModel);
viewModel.getObjects(20);
