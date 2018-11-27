import DenTravakAbstractElement from './den-travak-abstract-element.js';


class DenTravakOrderConfirmation extends DenTravakAbstractElement{

    get template(){
        return '<h3>Welkom bij Den Travak!</h3><button>Nieuwe bestelling</button>';
    }



}

customElements.define('dt-sandwiches-order-confirmation', DenTravakSandwichOrderConfirmation);

