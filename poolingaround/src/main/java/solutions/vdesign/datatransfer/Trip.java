package solutions.vdesign.datatransfer;

import java.util.Date;

import solutions.vdesign.util.CustomFormatter;

public class Trip extends BaseDTO {
    private String arrivo;
    private Date data;
    private int durata; // in ore
    private int id;
    private boolean isDisponibile;
    private String partenza;

    // Builder setters
    public Trip setArrivo(String newArrivo) {
        this.arrivo = newArrivo;
        return this;
    };

    public Trip setData(Date newData) {
        this.data = newData;
        return this;
    };

    public Trip setDurata(int newDurata) {
        this.durata = newDurata;
        return this;
    };

    public Trip setId(int newId) {
        this.id = newId;
        return this;
    };

    public Trip setIsDisponibile(boolean newIsDisponibile) {
        this.isDisponibile = newIsDisponibile;
        return this;
    };

    public Trip setIsDisponibile(String newIsDisponibile) {
        switch (newIsDisponibile.toLowerCase()) {
            case "si":
                this.isDisponibile = true;
                break;
            case "no":
                this.isDisponibile = false;
                break;
        
            default:
                throw new RuntimeException("Disponibilità può essere SI o NO se letta da stringa...");
        }
        return this;
    };

    public Trip setPartenza(String newPartenza) {
        this.partenza = newPartenza;
        return this;
    };


    //Getters

    public String getArrivo() {
        return this.arrivo;
    }

    public Date getData() {
        return this.data;
    };

    public String getDataString() {
        return CustomFormatter.getDateString(this.getData());

    };

    public int getDurata() {
        return this.durata;
    };

    public int getId() {
        return this.id;
    };

    public boolean getIsDisponibile() {
        return this.isDisponibile;
    };
    public String getIsDisponibileString() {
        if (this.getIsDisponibile()){
             return "SI";
        }
        else{
            return "NO";
        }
    };

    public String getPartenza() {
        return this.partenza;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-5s %-15s %-15s %-15s %-20s %-5s",
                    this.getId(),
                    this.getPartenza(),
                    this.getArrivo(),
                    this.getDataString(),
                    this.getDurata(), 
                    this.getIsDisponibileString()
                    ));

        return sb.toString();
    }
}

