package com.orangetalents3.orangetalents3.DTOs;

public class FipeInformationDTO {
    private String Valor;
    private String Marca;
    private String Modelo;
    private String Combustivel;
    private String CodigoFipe;
    private String MesReferencia;
    private String SiglaCombustivel;
    private int TipoVeiculo;
    private int AnoModelo;

    public String getValor() {
        return Valor;
    }

    public void setValor(String valor) {
        Valor = valor;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String modelo) {
        Modelo = modelo;
    }

    public String getCombustivel() {
        return Combustivel;
    }

    public void setCombustivel(String combustivel) {
        Combustivel = combustivel;
    }

    public String getCodigoFipe() {
        return CodigoFipe;
    }

    public void setCodigoFipe(String codigoFipe) {
        CodigoFipe = codigoFipe;
    }

    public String getMesReferencia() {
        return MesReferencia;
    }

    public void setMesReferencia(String mesReferencia) {
        MesReferencia = mesReferencia;
    }

    public String getSiglaCombustivel() {
        return SiglaCombustivel;
    }

    public void setSiglaCombustivel(String siglaCombustivel) {
        SiglaCombustivel = siglaCombustivel;
    }

    public int getTipoVeiculo() {
        return TipoVeiculo;
    }

    public void setTipoVeiculo(int tipoVeiculo) {
        TipoVeiculo = tipoVeiculo;
    }

    public int getAnoModelo() {
        return AnoModelo;
    }

    public void setAnoModelo(int anoModelo) {
        AnoModelo = anoModelo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FipeInformationDTO)) return false;

        FipeInformationDTO that = (FipeInformationDTO) o;

        if (getTipoVeiculo() != that.getTipoVeiculo()) return false;
        if (getAnoModelo() != that.getAnoModelo()) return false;
        if (getValor() != null ? !getValor().equals(that.getValor()) : that.getValor() != null) return false;
        if (getMarca() != null ? !getMarca().equals(that.getMarca()) : that.getMarca() != null) return false;
        if (getModelo() != null ? !getModelo().equals(that.getModelo()) : that.getModelo() != null) return false;
        if (getCombustivel() != null ? !getCombustivel().equals(that.getCombustivel()) : that.getCombustivel() != null)
            return false;
        if (getCodigoFipe() != null ? !getCodigoFipe().equals(that.getCodigoFipe()) : that.getCodigoFipe() != null)
            return false;
        if (getMesReferencia() != null ? !getMesReferencia().equals(that.getMesReferencia()) : that.getMesReferencia() != null)
            return false;
        return getSiglaCombustivel() != null ? getSiglaCombustivel().equals(that.getSiglaCombustivel()) : that.getSiglaCombustivel() == null;
    }

    @Override
    public int hashCode() {
        int result = getValor() != null ? getValor().hashCode() : 0;
        result = 31 * result + (getMarca() != null ? getMarca().hashCode() : 0);
        result = 31 * result + (getModelo() != null ? getModelo().hashCode() : 0);
        result = 31 * result + (getCombustivel() != null ? getCombustivel().hashCode() : 0);
        result = 31 * result + (getCodigoFipe() != null ? getCodigoFipe().hashCode() : 0);
        result = 31 * result + (getMesReferencia() != null ? getMesReferencia().hashCode() : 0);
        result = 31 * result + (getSiglaCombustivel() != null ? getSiglaCombustivel().hashCode() : 0);
        result = 31 * result + getTipoVeiculo();
        result = 31 * result + getAnoModelo();
        return result;
    }
}
