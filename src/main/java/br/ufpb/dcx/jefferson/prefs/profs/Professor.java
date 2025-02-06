package br.ufpb.dcx.jefferson.prefs.profs;

import java.util.Objects;

public class Professor {
    private String matriculaProf;
    private String nomeProf;

    public Professor(String nomeProf, String matriculaProf) {
        this.nomeProf = nomeProf;
        this.matriculaProf = matriculaProf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Professor professor = (Professor) o;
        return Objects.equals(matriculaProf, professor.matriculaProf) && Objects.equals(nomeProf, professor.nomeProf);
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
