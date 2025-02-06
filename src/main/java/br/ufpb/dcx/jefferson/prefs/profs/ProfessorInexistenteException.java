package br.ufpb.dcx.jefferson.prefs.profs;

public class ProfessorInexistenteException extends RuntimeException {
    public ProfessorInexistenteException(String message) {
        super(message);
    }
}
