package br.com.vemser.pessoaapi.service;

import br.com.vemser.pessoaapi.dto.PessoaDTO;
import br.com.vemser.pessoaapi.entity.Pessoa;
import br.com.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class EmailService {

    private final freemarker.template.Configuration fnConfiguration;

//    @Autowired
//    private PessoaService pessoaService;

    @Value("${spring.mail.username}")
    private String from;

    private final JavaMailSender emailSender;

    public void sendSimpleMessage() {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(from);
        message.setTo("willian.valentim@dbccompany.com.br");
        message.setSubject("Assunto de teste");
        message.setText("Meu e-mail de teste backend.");
        emailSender.send(message);
    }

    public void sendWithAttachment() throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setFrom(from);
        helper.setTo("willian.valentim@dbccompany.com.br");
        helper.setSubject("Assunto teste com imagem.");
        helper.setText("Meu e-mail de teste enviando imagem backend 2.");

        ClassLoader classLoader = getClass().getClassLoader();
        File file2 = new File(classLoader.getResource("imagem.png").getFile());
        FileSystemResource file = new FileSystemResource(file2);
        helper.addAttachment(file2.getName(), file);

        emailSender.send(message);
    }

    public void sendEmail() {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo("willian.valentim@dbccompany.com.br");
            mimeMessageHelper.setSubject("Assunto teste email 3");
            mimeMessageHelper.setText(getContentFromTemplate(), true);

            emailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
        }
    }

    private void sendEmailCreatePessoa(PessoaDTO pessoaDTO) {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(pessoaDTO.getEmail());
            mimeMessageHelper.setSubject("Seja muito bem vindo(a) ao nosso aplicativo!");
            mimeMessageHelper.setText(getContentFromTemplateCreatePessoa(pessoaDTO), true);
        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
        }
    }

    private String getContentFromTemplateCreatePessoa(PessoaDTO pessoaDTO) throws IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", pessoaDTO.getNome());
        dados.put("id", pessoaDTO.getIdPessoa());
        dados.put("email", from);

        Template template = fnConfiguration.getTemplate("emailCreatePessoa-template.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }

    private void sendEmailUpdatePessoa(PessoaDTO pessoaDTO) {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(pessoaDTO.getEmail());
            mimeMessageHelper.setSubject("Notificação: Os seus dados estão sendo atualizado.");
            mimeMessageHelper.setText(getContentFromTemplateUpdatePessoa(pessoaDTO), true);
        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
        }
    }

    private String getContentFromTemplateUpdatePessoa(PessoaDTO pessoaDTO) throws IOException, TemplateException{
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", pessoaDTO.getNome());
        dados.put("email", from);

        Template template = fnConfiguration.getTemplate("emailUpdatePessoa-template.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }

    private void sendEmailDeletePessoa(PessoaDTO pessoaDTO) {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(pessoaDTO.getEmail());
            mimeMessageHelper.setSubject("Notificação: Os seus dados foram apagados do nosso aplicativo.");
            mimeMessageHelper.setText(getContentFromTemplateDeletePessoa(pessoaDTO), true);
        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
        }
    }

    private String getContentFromTemplateDeletePessoa(PessoaDTO pessoaDTO) throws IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", pessoaDTO.getNome());
        dados.put("email", from);

        Template template = fnConfiguration.getTemplate("emailDeletePessoa-template.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }

    private void sendEmailCreateEndereco(PessoaDTO pessoaDTO) {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(pessoaDTO.getEmail());
            mimeMessageHelper.setSubject("Notificação: Novo endereço adicionado com sucesso!");
            mimeMessageHelper.setText(getContentFromTemplateCreatePessoa(pessoaDTO), true);
        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
        }
    }

    private String getContentFromTemplateCreateEndereco(PessoaDTO pessoaDTO) throws IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", pessoaDTO.getNome());
        dados.put("email", from);

        Template template = fnConfiguration.getTemplate("emailCreateEndereco-template.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }

    private void sendEmailUpdateEndereco(PessoaDTO pessoaDTO) {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(pessoaDTO.getEmail());
            mimeMessageHelper.setSubject("Notificação: Os dados endereço estão sendo atualizado.");
            mimeMessageHelper.setText(getContentFromTemplateUpdatePessoa(pessoaDTO), true);
        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
        }
    }

    private String getContentFromTemplateUpdateEndereco(PessoaDTO pessoaDTO) throws IOException, TemplateException{
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", pessoaDTO.getNome());
        dados.put("email", from);

        Template template = fnConfiguration.getTemplate("emailUpdateEndereco-template.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }

    private void sendEmailDeleteEndereco(PessoaDTO pessoaDTO) {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(pessoaDTO.getEmail());
            mimeMessageHelper.setSubject("Notificação: Os seus dados de endereço foram apagados do nosso aplicativo.");
            mimeMessageHelper.setText(getContentFromTemplateDeletePessoa(pessoaDTO), true);
        } catch (MessagingException | IOException | TemplateException e) {
            e.printStackTrace();
        }
    }

    private String getContentFromTemplateDeleteEndereco(PessoaDTO pessoaDTO) throws IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", pessoaDTO.getNome());
        dados.put("email", from);

        Template template = fnConfiguration.getTemplate("emailDeleteEndereco-template.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }

    public String getContentFromTemplate() throws IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", "Meu nome");
        dados.put("email", "willian.valentim@dbccompany.com.br");

        Template template = fnConfiguration.getTemplate("email-template.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }
}
