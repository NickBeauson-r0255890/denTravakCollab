import AbstractDenTravakElement from './den-travak-abstract-element';
class DenTravakApp extends AbstractDenTravakElement{

    get template(){
        return '<dt-sandwiches-list></dt-sandwiches-list><dt-sandwiches-checkout></dt-sandwiches-checkout><dt-sandwiches-order-confirmation></dt-sandwiches-order-confirmation>        ';

    }
}
customElements.element.define('dt-app', DenTravakApp);

