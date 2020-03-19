#language: pt
#Author: Thiago Benites
@contingencia
Funcionalidade: Erros de contingencia
  Eu como sistema
  Quero validar os erros de contingencia nos fluxos de negocio

  # Leticia Kons
  @36286
  Cenario: 36286:Disparar e-mail de cancelamento para o pedido quando ha erro de negocio no fluxo de contingencia
    Dado que acesso o sistema
    Entao realizo login
    
  # Maria Correia
  @39103
  Cenario: 39103:Garantir que erros de autenticacao nas integracoes sejam classificados como erro tecnico contingencia
    Dado que acesso o sistema
    Entao realizo login