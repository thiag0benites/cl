#language: pt
#Author: Thiago Benites
@newtours
Funcionalidade: Testes basicos no google
  Eu como um usuário
  Quero realizar uma reserva de voo

  Contexto: Acesso o sistema de reserva
    Dado que acesso o sistema
    Entao realizo login

  @smoketest
  Esquema do Cenario: CT01_Reserva voo
    Quando preencho os dados da reserva "Dados"
      | "Round Trip"          |
      |                     1 |
      | London                |
      | December              |
      |                    20 |
      | Acapulco              |
      | October               |
      |                    21 |
      | "First"               |
      | "Blue Skies Airlines" |
    E estou na tela "SELECT FLIGHT"
    E seleciono o voo de ida <Ida>
    E seleciono o voo de volta <Volta>
    E estou na tela "BOOK A FLIGHT"
    E valido os dados de voo <Ida> e <Volta>
    E preencho os campos obrigatorios <Nome>, <SobreNome> e <Cartao>
    Quando estou na tela "FLIGHT CONFIRMATION"
    Entao valido o numero de reserva

    Exemplos: 
      | Ida                       | Volta                     | Nome        | SobreNome | Cartao         |
      | "Blue Skies Airlines 361" | "Blue Skies Airlines 631" | "Automacao" | "Teste"   | "118989038904" |
