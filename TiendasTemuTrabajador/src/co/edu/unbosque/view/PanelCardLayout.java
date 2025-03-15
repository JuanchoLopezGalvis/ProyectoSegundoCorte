package co.edu.unbosque.view;

import java.awt.CardLayout;

import javax.swing.JPanel;

/**
 * Panel con la responsabilidad de mostrar cada panel del CRUD
 */
public class PanelCardLayout extends JPanel{
	
	private CardLayout cardLayout;
	/**
	 * Instancias privadas de los paneles en los que se realizan las operaciones de CRUD
	 */
	private PanelActualizarProductoHogarBanio pacphb;
	private PanelActualizarProductoHogarCocina pacphc;
	private PanelActualizarProductoOcioJuguete pacpoj;
	private PanelActualizarProductoOcioRopa pacpor;
	private PanelActualizarProductoOficinaElectrodomestico pacpoe;
	private PanelActualizarProductoOficinaPapeleria pacpop;
	private PanelAgregarProductoHogarBanio pagphb;
	private PanelAgregarProductoHogarCocina pagphc;
	private PanelAgregarProductoOcioJuguete pagpoj;
	private PanelAgregarProductoOcioRopa pagpor;
	private PanelAgregarProductoOficinaElectrodomestico pagpoe;
	private PanelAgregarProductoOficinaPapeleria pagpop;
	private PanelEliminarProductoHogarBanio pephb;
	private PanelEliminarProductoHogarCocina pephc;
	private PanelEliminarProductoOcioJuguete pepoj;
	private PanelEliminarProductoOcioRopa pepor;
	private PanelEliminarProductoOficinaElectrodomestico pepoe;
	private PanelEliminarProductoOficinaPapeleria pepop;
	private PanelListarProductoHogarBanio plphb;
	private PanelListarProductoHogarCocina plphc;
	private PanelListarProductoOcioJuguete plpoj;
	private PanelListarProductoOcioRopa plpor;
	private PanelListarProductoOficinaElectrodomestico plpoe;
	private PanelListarProductoOficinaPapeleria plpop;
	
	/**
	 * Constructor de la clase PanelCardLayout
	 * Donde se inicializan los paneles de las operaciones de CRUD
	 */
	public PanelCardLayout() {
		
		
		cardLayout = new CardLayout();
		setLayout(cardLayout);
		pacphb = new PanelActualizarProductoHogarBanio();
		pacphc = new PanelActualizarProductoHogarCocina();
		pacpoj = new PanelActualizarProductoOcioJuguete();
		pacpor = new PanelActualizarProductoOcioRopa();
		pacpoe = new PanelActualizarProductoOficinaElectrodomestico();
		pacpop = new PanelActualizarProductoOficinaPapeleria();
		pagphb = new PanelAgregarProductoHogarBanio();
		pagphc = new PanelAgregarProductoHogarCocina();
		pagpoj = new PanelAgregarProductoOcioJuguete();
		pagpor = new PanelAgregarProductoOcioRopa();
		pagpoe = new PanelAgregarProductoOficinaElectrodomestico();
		pagpop = new PanelAgregarProductoOficinaPapeleria();
		pephb = new PanelEliminarProductoHogarBanio();
		pephc = new PanelEliminarProductoHogarCocina();
		pepoj = new PanelEliminarProductoOcioJuguete();
		pepor = new PanelEliminarProductoOcioRopa();
		pepoe = new PanelEliminarProductoOficinaElectrodomestico();
		pepop = new PanelEliminarProductoOficinaPapeleria();
		plphb = new PanelListarProductoHogarBanio();
		plphc = new PanelListarProductoHogarCocina();
		plpoj = new PanelListarProductoOcioJuguete();
		plpor = new PanelListarProductoOcioRopa();
		plpoe = new PanelListarProductoOficinaElectrodomestico();
		plpop = new PanelListarProductoOficinaPapeleria();
		
		add(pacphb, "pacphb");
		add(pacphc, "pacphc");
		add(pacpoj, "pacpoj");
		add(pacpor, "pacpor");
		add(pacpoe, "pacpoe");
		add(pacpop, "pacpop");
		add(pagphb, "pagphb");
		add(pagphc, "pagphc");
		add(pagpoj, "pagpoj");
		add(pagpor, "pagpor");
		add(pagpoe, "pagpoe");
		add(pagpop, "pagpop");
		add(pephb, "pephb");
		add(pephc, "pephc");
		add(pepoj, "pepoj");
		add(pepor, "pepor");
		add(pepoe, "pepoe");
		add(pepop, "pepop");
		add(plphb, "plphb");
		add(plphc, "plphc");
		add(plpoj, "plpoj");
		add(plpor, "plpor");
		add(plpoe, "plpoe");
		add(plpop, "plpop");
		
	}

	/**
	 * Metodo que permite mostrar un panel en especifico
	 * @param panel
	 */
	public void mostrarPanel(String panel) {
		cardLayout.show(this, panel);
	}
	/**
	 *Todos los getters y setters de los atributos de la clase PanelCardLayout 
	 * 
	 */
	public PanelActualizarProductoHogarBanio getPacphb() {
		return pacphb;
	}

	public void setPacphb(PanelActualizarProductoHogarBanio pacphb) {
		this.pacphb = pacphb;
	}

	public PanelActualizarProductoHogarCocina getPacphc() {
		return pacphc;
	}

	public void setPacphc(PanelActualizarProductoHogarCocina pacphc) {
		this.pacphc = pacphc;
	}

	public PanelActualizarProductoOcioJuguete getPacpoj() {
		return pacpoj;
	}

	public void setPacpoj(PanelActualizarProductoOcioJuguete pacpoj) {
		this.pacpoj = pacpoj;
	}

	public PanelActualizarProductoOcioRopa getPacpor() {
		return pacpor;
	}

	public void setPacpor(PanelActualizarProductoOcioRopa pacpor) {
		this.pacpor = pacpor;
	}

	public PanelActualizarProductoOficinaElectrodomestico getPacpoe() {
		return pacpoe;
	}

	public void setPacpoe(PanelActualizarProductoOficinaElectrodomestico pacpoe) {
		this.pacpoe = pacpoe;
	}

	public PanelActualizarProductoOficinaPapeleria getPacpop() {
		return pacpop;
	}

	public void setPacpop(PanelActualizarProductoOficinaPapeleria pacpop) {
		this.pacpop = pacpop;
	}

	public PanelAgregarProductoHogarBanio getPagphb() {
		return pagphb;
	}

	public void setPagphb(PanelAgregarProductoHogarBanio pagphb) {
		this.pagphb = pagphb;
	}

	public PanelAgregarProductoHogarCocina getPagphc() {
		return pagphc;
	}

	public void setPagphc(PanelAgregarProductoHogarCocina pagphc) {
		this.pagphc = pagphc;
	}

	public PanelAgregarProductoOcioJuguete getPagpoj() {
		return pagpoj;
	}

	public void setPagpoj(PanelAgregarProductoOcioJuguete pagpoj) {
		this.pagpoj = pagpoj;
	}

	public PanelAgregarProductoOcioRopa getPagpor() {
		return pagpor;
	}

	public void setPagpor(PanelAgregarProductoOcioRopa pagpor) {
		this.pagpor = pagpor;
	}

	public PanelAgregarProductoOficinaElectrodomestico getPagpoe() {
		return pagpoe;
	}

	public void setPagpoe(PanelAgregarProductoOficinaElectrodomestico pagpoe) {
		this.pagpoe = pagpoe;
	}

	public PanelAgregarProductoOficinaPapeleria getPagpop() {
		return pagpop;
	}

	public void setPagpop(PanelAgregarProductoOficinaPapeleria pagpop) {
		this.pagpop = pagpop;
	}

	public PanelEliminarProductoHogarBanio getPephb() {
		return pephb;
	}

	public void setPephb(PanelEliminarProductoHogarBanio pephb) {
		this.pephb = pephb;
	}

	public PanelEliminarProductoHogarCocina getPephc() {
		return pephc;
	}

	public void setPephc(PanelEliminarProductoHogarCocina pephc) {
		this.pephc = pephc;
	}

	public PanelEliminarProductoOcioJuguete getPepoj() {
		return pepoj;
	}

	public void setPepoj(PanelEliminarProductoOcioJuguete pepoj) {
		this.pepoj = pepoj;
	}

	public PanelEliminarProductoOcioRopa getPepor() {
		return pepor;
	}

	public void setPepor(PanelEliminarProductoOcioRopa pepor) {
		this.pepor = pepor;
	}

	public PanelEliminarProductoOficinaElectrodomestico getPepoe() {
		return pepoe;
	}

	public void setPepoe(PanelEliminarProductoOficinaElectrodomestico pepoe) {
		this.pepoe = pepoe;
	}

	public PanelEliminarProductoOficinaPapeleria getPepop() {
		return pepop;
	}

	public void setPepop(PanelEliminarProductoOficinaPapeleria pepop) {
		this.pepop = pepop;
	}

	public PanelListarProductoHogarBanio getPlphb() {
		return plphb;
	}

	public void setPlphb(PanelListarProductoHogarBanio plphb) {
		this.plphb = plphb;
	}

	public PanelListarProductoHogarCocina getPlphc() {
		return plphc;
	}

	public void setPlphc(PanelListarProductoHogarCocina plphc) {
		this.plphc = plphc;
	}

	public PanelListarProductoOcioJuguete getPlpoj() {
		return plpoj;
	}

	public void setPlpoj(PanelListarProductoOcioJuguete plpoj) {
		this.plpoj = plpoj;
	}

	public PanelListarProductoOcioRopa getPlpor() {
		return plpor;
	}

	public void setPlpor(PanelListarProductoOcioRopa plpor) {
		this.plpor = plpor;
	}

	public PanelListarProductoOficinaElectrodomestico getPlpoe() {
		return plpoe;
	}

	public void setPlpoe(PanelListarProductoOficinaElectrodomestico plpoe) {
		this.plpoe = plpoe;
	}

	public PanelListarProductoOficinaPapeleria getPlpop() {
		return plpop;
	}

	public void setPlpop(PanelListarProductoOficinaPapeleria plpop) {
		this.plpop = plpop;
	}
	
	
	

}
