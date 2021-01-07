package com.jha.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.jha.cursomc.domain.Pedido;

public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);

	void sendEmail(SimpleMailMessage msg);
}