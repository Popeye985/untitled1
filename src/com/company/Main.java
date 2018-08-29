package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        HashMap<String, BankRekening> rekeningen = new HashMap();
        Scanner invoer = new Scanner(System.in);
        System.out.println("Rekeningen maken");
        for (int i = 0; i < 4 ; i++) {
            System.out.println("Geef Bankrekening:");
            String rekeningnummer = invoer.nextLine();
            //BankRekening br = new BankRekening(rekeningnummer);
            //rekeningen.put(rekeningnummer, br);
            rekeningen.put(rekeningnummer, new BankRekening(rekeningnummer));

        }
        System.out.println("Op welke rekening wilt u storten?");
        String rek = invoer.nextLine();
        BankRekening br = rekeningen.get(rek);


        System.out.println("Hoeveel geld wilt u storten?");
        int gestortBedrag= Integer.parseInt(invoer.nextLine());
        br.storten(gestortBedrag);



        for (BankRekening bankrek :rekeningen.values()){
            System.out.printf("Het resultaat: %n %s %d EURO%n", bankrek.getRekeningnummer(), bankrek.getSaldo());
        }




    }
}
class BankRekening{
    private String rekeningnummer;
    private int saldo;

    public BankRekening(String rekeningnummer) {
        this.rekeningnummer = rekeningnummer;
    }

    public String getRekeningnummer() {
        return rekeningnummer;
    }

    public int getSaldo() {
        return saldo;
    }
    public void storten(int bedrag){
        saldo += bedrag;
    }
    public void afhalen(int bedrag){
        saldo -= bedrag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankRekening that = (BankRekening) o;
        return saldo == that.saldo &&
                Objects.equals(rekeningnummer, that.rekeningnummer);
    }

    @Override
    public int hashCode() {

        return Objects.hash(rekeningnummer);
    }
}