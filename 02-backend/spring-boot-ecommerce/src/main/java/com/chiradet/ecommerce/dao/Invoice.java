package com.chiradet.ecommerce.dao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Invoice {

    private int id;
    private double amount;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDue_date() {
        return due_date;
    }

    public void setDue_date(LocalDate due_date) {
        this.due_date = due_date;
    }

    public LocalDate getPaid_date() {
        return paid_date;
    }

    public void setPaid_date(LocalDate paid_date) {
        this.paid_date = paid_date;
    }

    private LocalDate due_date;
    private LocalDate paid_date;

    public Invoice(int id, double amount, LocalDate due_date, LocalDate paid_date) {
        this.id = id;
        this.amount = amount;
        this.due_date = due_date;
        this.paid_date = paid_date;
    }

    public static List<Invoice> getOverdueInvoices(List<Invoice> invoices) {
        List<Invoice> overdueInvoices = new ArrayList<>();
        LocalDate currentDate = LocalDate.parse("2023-05-01", DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        for (Invoice invoice : invoices) {
            if ((invoice.getPaid_date() == null && invoice.getDue_date().isBefore(currentDate) )
                    || (invoice.getPaid_date() == null && invoice.getDue_date().isEqual(currentDate))) {
                overdueInvoices.add(invoice);
            }

        }

        return overdueInvoices;
    }

    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        List<Invoice> invoices = new ArrayList<>();
        invoices.add(new Invoice(1, 50, LocalDate.parse("2023-03-31", formatter), LocalDate.parse("2023-04-30", formatter)));
        invoices.add(new Invoice(2, 100, LocalDate.parse("2023-04-30", formatter), LocalDate.parse("2023-05-05", formatter)));
        invoices.add(new Invoice(3, 150, LocalDate.parse("2023-04-15", formatter), null));
        invoices.add(new Invoice(4, 200, LocalDate.parse("2023-04-01", formatter), LocalDate.parse("2023-04-30", formatter)));

        List<Invoice> invoiceList = getOverdueInvoices(invoices);
        for (Invoice inv : invoiceList){
            System.out.println("Invoice ID: " + inv.getId());
            System.out.println("Invoice Amount: " + inv.getAmount());
            System.out.println("Invoice Due Date: " + inv.getDue_date());
            System.out.println("Invoice Paid Date: " + inv.getPaid_date());
            System.out.println();
        }
    }

}
