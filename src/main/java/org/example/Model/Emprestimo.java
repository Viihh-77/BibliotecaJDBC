package org.example.Model;

import java.sql.Date;

public class Emprestimo {

    private int id;
    private int idLivro;
    private int idUsuario;
    private Date dataEmprestimo;
    private Date dataDevolucao;

    public Emprestimo(int id, int idLivro, int idUsuario, Date dataEmprestimo, Date dataDevolucao) {
        this.id = id;
        this.idLivro = idLivro;
        this.idUsuario = idUsuario;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
    }

    public Emprestimo(int idLivro, int idUsuario, Date dataEmprestimo, Date dataDevolucao) {
        this.idLivro = idLivro;
        this.idUsuario = idUsuario;
        this.dataEmprestimo = dataEmprestimo;
        this.dataDevolucao = dataDevolucao;
    }

    public Emprestimo(int idLivro, int idUsuario) {
        this.idLivro = idLivro;
        this.idUsuario = idUsuario;
    }

    public Emprestimo(int id, Date dataDevolucao) {
        this.id = id;
        this.dataDevolucao = dataDevolucao;
    }

    public int getId() {
        return id;
    }

    public int getIdLivro() {
        return idLivro;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public Date getDataEmprestimo() {
        return dataEmprestimo;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdLivro(int idLivro) {
        this.idLivro = idLivro;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setDataEmprestimo(Date dataEmprestimo) {
        this.dataEmprestimo = dataEmprestimo;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }
}
