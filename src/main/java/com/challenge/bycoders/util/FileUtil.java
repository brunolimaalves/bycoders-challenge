package com.challenge.bycoders.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileUtil {

    private FileUtil(){}

    private static final Integer[] TIPO = {0,   1};
    private static final Integer[] DATA = {1,   9};
    private static final Integer[] VALOR = {9,  19};
    private static final Integer[] CPF = {19, 30};
    private static final Integer[] CARTAO = {30, 42};
    private static final Integer[] HORA = {42, 48};
    private static final Integer[] PROPRIETARIO = {48, 62};
    private static final Integer[] LOJA = {62, 80};

    public static Long getTipoTransacao(String transacao) {
        return Long.valueOf(transacao.substring(TIPO[0], TIPO[1]));
    }

    public static Date getDataTransacao(String transacao) throws ParseException {
        return new SimpleDateFormat("yyyyMMdd").parse(transacao.substring(DATA[0], DATA[1]));
    }

    public static BigDecimal getValorTransacao(String transacao) {
        return new BigDecimal(transacao.substring(VALOR[0], VALOR[1]));
    }

    public static String getCPFTransacao(String transacao) {
        return transacao.substring(CPF[0], CPF[1]).trim();
    }

    public static String getCartaoTransacao(String transacao) {
        return transacao.substring(CARTAO[0], CARTAO[1]).trim();
    }

    public static Date getHoraTransacao(String transacao) throws ParseException {
        return new SimpleDateFormat("HHmmss").parse(transacao.substring(HORA[0], HORA[1]));
    }

    public static String getProprietarioTransacao(String transacao) {
        return transacao.substring(PROPRIETARIO[0], PROPRIETARIO[1]).trim();
    }

    public static String getLojaTransacao(String transacao) {
        return transacao.substring(LOJA[0], LOJA[1]).trim();
    }

    public static String[] getBody(MultipartFile file) throws IOException {
        return new String(file.getBytes(), StandardCharsets.UTF_8).split("\n");
    }

}
