package com.challenge.bycoders.factory;

import com.challenge.bycoders.entity.Proprietario;
import com.challenge.bycoders.entity.TipoTransacao;
import com.challenge.bycoders.entity.Transacao;
import com.challenge.bycoders.entity.TransacaoLoja;
import com.challenge.bycoders.util.FileUtil;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public interface IParseStringToFile {

    default String[] toString(MultipartFile file) throws IOException {
        return FileUtil.getBody(file);
    }

    Set<TransacaoLoja> getProprietarioLoja(MultipartFile file, List<Proprietario> proprietarios) throws IOException;

    List<Transacao> getTransacoes(MultipartFile file, List<TransacaoLoja> lojas,
                                    List<TipoTransacao> tipos) throws Exception;

    Set<Proprietario> getProprietarios(MultipartFile file) throws IOException;
}
