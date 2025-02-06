package br.ufpb.dcx.jefferson.prefs.profs;

import java.util.Objects;

public class Area {
    private String codArea;
    private String nomeArea;

    public Area(String codArea, String nomeArea) {
        this.codArea = codArea;
        this.nomeArea = nomeArea;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Area area = (Area) o;
        return Objects.equals(codArea, area.codArea) && Objects.equals(nomeArea, area.nomeArea);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codArea, nomeArea);
    }

    public String getCodArea() {
        return codArea;
    }

    public String getNomeArea() {
        return nomeArea;
    }
    @Override
    public String toString(){
        return "TODO";
    }
}
