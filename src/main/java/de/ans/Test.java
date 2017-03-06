package de.ans;

public class Test {
	private String artikel;
	private Integer bestellmenge;
	private String beschreibung;
	private Integer kalendertage_bis_lieferung;

	public String getArtikel() {
		return artikel;
	}

	public void setArtikel(String artikel) {
		this.artikel = artikel;
	}

	public Integer getBestellmenge() {
		return bestellmenge;
	}

	public void setBestellmenge(Integer bestellmenge) {
		this.bestellmenge = bestellmenge;
	}

	public String getBeschreibung() {
		return beschreibung;
	}

	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}

	public Integer getKalendertage_bis_lieferung() {
		return kalendertage_bis_lieferung;
	}

	public void setKalendertage_bis_lieferung(Integer kalendertage_bis_lieferung) {
		this.kalendertage_bis_lieferung = kalendertage_bis_lieferung;
	}

	@Override
	public String toString() {
		return String.format("Test [artikel=%s, bestellmenge=%s, beschreibung=%s, kalendertage_bis_lieferung=%s]",
				artikel, bestellmenge, beschreibung, kalendertage_bis_lieferung);
	}

}
