/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.adrianob.services;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.jdesktop.beansbinding.Converter;

/**
 *
 * @author Administrador
 */
public class ConverterDateTime extends Converter<Date, String> {

    @Override
    public String convertForward(Date value) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy H:m:s");
        return df.format(value);
    }

    @Override
    public Date convertReverse(String value) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy H:m:s");
        try {
            return df.parse(value);
        } catch (ParseException ex) {
            return null;
        }
    }

}
