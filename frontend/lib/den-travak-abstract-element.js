export default class DenTravakAbstractElement extends HTMLElement{

    connectedCallback() {
        this.initShadowDom();
      }
      
      initShadowDom() {
        let shadowRoot = this.attachShadow({mode: 'open'});
        shadowRoot.innerHTML = this.template;
      }
        get template() {
      
        }
      byId(){
      return this.shadowRoot.querySelector("#$(id)");

      }
}