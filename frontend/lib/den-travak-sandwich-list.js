import AbstractDenTravakElement from './den-travak-abstract-element';
class DenTravakSandwichList extends AbstractDenTravakElement{


    fetchAndShowSandwiches() // HTTP fetch json
{
		Fetch("api/sandwiches.json")
		.then(resp => resp.json()
		.then(sandwiches => this.showSandwiches(sandwiches)));
}


ShowSandwiches(sandwiches){
	this.shadowroot.queryselector("#sandwiches") // this.byId(#sandwiches)
	SandwichesUl.innerHTML = "";
	Sandwiches.forEach(sandwich => {
		sandwichesLi = document.createElement("li");
		Sandwiches.UL.appendChild(sandwichLi);
		sandwichLi.InnerHTML = sandwich.name;
		})
    }

    get template(){
	return " <ul id='sandwiches'> </ul>";

    }
}

customElements.define('dt-sandwichlist', DenTravakSandwichList);

