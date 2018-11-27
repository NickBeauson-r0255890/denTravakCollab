import AbstractDenTravakElement from '../den-travak-abstract-element';

import './den-travak-sandwich-list';
import './-sandwiches-checkout.js';
import './travak-sandwiches-order-confirmation.js';

class DenTravakApp extends AbstractDenTravakElement{


    connectedCallback() {
        super.connectedCallback();
        this.showSandwichList();
        this.initEventListeners();
    }



    initEventListeners(){
        this.addEventListener('checkout', (e) => this.showCheckoutPage(e.detail));
        this.addEventListener('order-succeeded', (e) => this.showOrderConfirmationPage(e.detail));
        this.addEventListener('show-sandwich-list', (e) => this.showSandwichList());
    }

    showSandwichList() {
        this.byCss(`dt-sandwiches-list`).classList.remove('hidden');
        this.byCss(`dt-sandwiches-checkout`).classList.add('hidden');
        this.byCss(`dt-sandwiches-order-confirmation`).classList.add('hidden');
    }

    showCheckoutPage(sandwich) {
        this.byCss(`dt-sandwiches-checkout`).init(sandwich);
        this.byCss(`dt-sandwiches-list`).classList.add('hidden');
        this.byCss(`dt-sandwiches-checkout`).classList.remove('hidden');
        this.byCss(`dt-sandwiches-order-confirmation`).classList.add('hidden');
    }

    showOrderConfirmationPage(sandwich) {
        this.byCss(`dt-sandwiches-order-confirmation`).init(sandwich);
        this.byCss(`dt-sandwiches-list`).classList.add('hidden');
        this.byCss(`dt-sandwiches-checkout`).classList.add('hidden');
        this.byCss(`dt-sandwiches-order-confirmation`).classList.remove('hidden');
    }
    get template(){
        return '<dt-sandwiches-list></dt-sandwiches-list><dt-sandwiches-checkout></dt-sandwiches-checkout><dt-sandwiches-order-confirmation></dt-sandwiches-order-confirmation>        ';

    }
}
customElements.element.define('dt-app', DenTravakApp);

