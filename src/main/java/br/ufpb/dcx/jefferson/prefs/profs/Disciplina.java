package br.ufpb.dcx.jefferson.prefs.profs;

import java.util.Objects;

public class Disciplina {
    private String matriculaProf;
    private String nomeProf;

    public Disciplina(String matriculaProf, String nomeProf) {
        this.matriculaProf = matriculaProf;
        this.nomeProf = nomeProf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Disciplina that = (Disciplina) o;
        return Objects.equals(matriculaProf, that.matriculaProf) && Objects.equals(nomeProf, that.nomeProf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matriculaProf, nomeProf);
    }

    public String getMatriculaProf() {
        return matriculaProf;
    }

    public String getNomeProf() {
        return nomeProf;
    }
    @Override
    public String toString(){
        return "TODO";
    }
}
