package rocha.andre.streaming.models;

public class Address {
    private String zipCode;
    private String street;
    private String complement;
    private String district;
    private String city;
    private String state;

    public Address(String zipCode, String street) {
        this.zipCode = zipCode;
        this.street = street;
    }

    public Address(AddressConsultaCep addressConsultaCep) {
        this.zipCode = addressConsultaCep.cep();
        this.street = addressConsultaCep.logradouro();
        this.complement = addressConsultaCep.complemento();
        this.district = addressConsultaCep.bairro();
        this.city = addressConsultaCep.localidade();
        this.state = addressConsultaCep.uf();
    }

    @Override
    public String toString() {
        return "O endereço é " + street + ", " + district + ", " + city + ", " + state + ", ";
    }
}
