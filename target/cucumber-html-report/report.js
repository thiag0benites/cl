$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("newtours.feature");
formatter.feature({
  "comments": [
    {
      "line": 1,
      "value": "#language: pt"
    },
    {
      "line": 2,
      "value": "#Author: Thiago Benites"
    }
  ],
  "line": 4,
  "name": "Testes basicos no google",
  "description": "Eu como um usuário\r\nQuero realizar uma reserva de voo",
  "id": "testes-basicos-no-google",
  "keyword": "Funcionalidade",
  "tags": [
    {
      "line": 3,
      "name": "@newtours"
    }
  ]
});
formatter.scenarioOutline({
  "line": 13,
  "name": "CT01_Reserva voo",
  "description": "",
  "id": "testes-basicos-no-google;ct01-reserva-voo",
  "type": "scenario_outline",
  "keyword": "Esquema do Cenario",
  "tags": [
    {
      "line": 12,
      "name": "@smoketest"
    }
  ]
});
formatter.step({
  "line": 14,
  "name": "preencho os dados da reserva \"Dados\"",
  "rows": [
    {
      "cells": [
        "\"Round Trip\""
      ],
      "line": 15
    },
    {
      "cells": [
        "1"
      ],
      "line": 16
    },
    {
      "cells": [
        "London"
      ],
      "line": 17
    },
    {
      "cells": [
        "December"
      ],
      "line": 18
    },
    {
      "cells": [
        "20"
      ],
      "line": 19
    },
    {
      "cells": [
        "Acapulco"
      ],
      "line": 20
    },
    {
      "cells": [
        "October"
      ],
      "line": 21
    },
    {
      "cells": [
        "21"
      ],
      "line": 22
    },
    {
      "cells": [
        "\"First\""
      ],
      "line": 23
    },
    {
      "cells": [
        "\"Blue Skies Airlines\""
      ],
      "line": 24
    }
  ],
  "keyword": "Quando "
});
formatter.step({
  "line": 25,
  "name": "estou na tela \"SELECT FLIGHT\"",
  "keyword": "E "
});
formatter.step({
  "line": 26,
  "name": "seleciono o voo de ida \u003cIda\u003e",
  "keyword": "E "
});
formatter.step({
  "line": 27,
  "name": "seleciono o voo de volta \u003cVolta\u003e",
  "keyword": "E "
});
formatter.step({
  "line": 28,
  "name": "estou na tela \"BOOK A FLIGHT\"",
  "keyword": "E "
});
formatter.step({
  "line": 29,
  "name": "valido os dados de voo \u003cIda\u003e e \u003cVolta\u003e",
  "keyword": "E "
});
formatter.step({
  "line": 30,
  "name": "preencho os campos obrigatorios \u003cNome\u003e, \u003cSobreNome\u003e e \u003cCartao\u003e",
  "keyword": "E "
});
formatter.step({
  "line": 31,
  "name": "estou na tela \"FLIGHT CONFIRMATION\"",
  "keyword": "Quando "
});
formatter.step({
  "line": 32,
  "name": "valido o numero de reserva",
  "keyword": "Entao "
});
formatter.examples({
  "line": 34,
  "name": "",
  "description": "",
  "id": "testes-basicos-no-google;ct01-reserva-voo;",
  "rows": [
    {
      "cells": [
        "Ida",
        "Volta",
        "Nome",
        "SobreNome",
        "Cartao"
      ],
      "line": 35,
      "id": "testes-basicos-no-google;ct01-reserva-voo;;1"
    },
    {
      "cells": [
        "\"Blue Skies Airlines 361\"",
        "\"Blue Skies Airlines 631\"",
        "\"Automacao\"",
        "\"Teste\"",
        "\"118989038904\""
      ],
      "line": 36,
      "id": "testes-basicos-no-google;ct01-reserva-voo;;2"
    }
  ],
  "keyword": "Exemplos"
});
formatter.before({
  "duration": 10117623100,
  "status": "passed"
});
formatter.background({
  "line": 8,
  "name": "Acesso o sistema de reserva",
  "description": "",
  "type": "background",
  "keyword": "Contexto"
});
formatter.step({
  "line": 9,
  "name": "que acesso o sistema",
  "keyword": "Dado "
});
formatter.step({
  "line": 10,
  "name": "realizo login",
  "keyword": "Entao "
});
formatter.match({
  "location": "NewToursSteps.queAcessoOSistema()"
});
formatter.result({
  "duration": 4498554600,
  "status": "passed"
});
formatter.match({
  "location": "NewToursSteps.realizoLogin()"
});
formatter.write("Teste Print");
formatter.embedding("image/png", "embedded0.png");
formatter.result({
  "duration": 6424423700,
  "status": "passed"
});
formatter.scenario({
  "line": 36,
  "name": "CT01_Reserva voo",
  "description": "",
  "id": "testes-basicos-no-google;ct01-reserva-voo;;2",
  "type": "scenario",
  "keyword": "Esquema do Cenario",
  "tags": [
    {
      "line": 3,
      "name": "@newtours"
    },
    {
      "line": 12,
      "name": "@smoketest"
    }
  ]
});
formatter.step({
  "line": 14,
  "name": "preencho os dados da reserva \"Dados\"",
  "rows": [
    {
      "cells": [
        "\"Round Trip\""
      ],
      "line": 15
    },
    {
      "cells": [
        "1"
      ],
      "line": 16
    },
    {
      "cells": [
        "London"
      ],
      "line": 17
    },
    {
      "cells": [
        "December"
      ],
      "line": 18
    },
    {
      "cells": [
        "20"
      ],
      "line": 19
    },
    {
      "cells": [
        "Acapulco"
      ],
      "line": 20
    },
    {
      "cells": [
        "October"
      ],
      "line": 21
    },
    {
      "cells": [
        "21"
      ],
      "line": 22
    },
    {
      "cells": [
        "\"First\""
      ],
      "line": 23
    },
    {
      "cells": [
        "\"Blue Skies Airlines\""
      ],
      "line": 24
    }
  ],
  "keyword": "Quando "
});
formatter.step({
  "line": 25,
  "name": "estou na tela \"SELECT FLIGHT\"",
  "keyword": "E "
});
formatter.step({
  "line": 26,
  "name": "seleciono o voo de ida \"Blue Skies Airlines 361\"",
  "matchedColumns": [
    0
  ],
  "keyword": "E "
});
formatter.step({
  "line": 27,
  "name": "seleciono o voo de volta \"Blue Skies Airlines 631\"",
  "matchedColumns": [
    1
  ],
  "keyword": "E "
});
formatter.step({
  "line": 28,
  "name": "estou na tela \"BOOK A FLIGHT\"",
  "keyword": "E "
});
formatter.step({
  "line": 29,
  "name": "valido os dados de voo \"Blue Skies Airlines 361\" e \"Blue Skies Airlines 631\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "E "
});
formatter.step({
  "line": 30,
  "name": "preencho os campos obrigatorios \"Automacao\", \"Teste\" e \"118989038904\"",
  "matchedColumns": [
    2,
    3,
    4
  ],
  "keyword": "E "
});
formatter.step({
  "line": 31,
  "name": "estou na tela \"FLIGHT CONFIRMATION\"",
  "keyword": "Quando "
});
formatter.step({
  "line": 32,
  "name": "valido o numero de reserva",
  "keyword": "Entao "
});
formatter.match({
  "arguments": [
    {
      "val": "Dados",
      "offset": 30
    }
  ],
  "location": "NewToursSteps.preenchoOsDadosDaReserva(String,DataTable)"
});
formatter.result({
  "duration": 2339400,
  "error_message": "cucumber.api.PendingException: TODO: implement me\r\n\tat steps.NewToursSteps.preenchoOsDadosDaReserva(NewToursSteps.java:31)\r\n\tat ✽.Quando preencho os dados da reserva \"Dados\"(newtours.feature:14)\r\n",
  "status": "pending"
});
formatter.match({
  "arguments": [
    {
      "val": "SELECT FLIGHT",
      "offset": 15
    }
  ],
  "location": "NewToursSteps.estouNaTela(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "Blue Skies Airlines 361",
      "offset": 24
    }
  ],
  "location": "NewToursSteps.selecionoOVooDeIda(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "Blue Skies Airlines 631",
      "offset": 26
    }
  ],
  "location": "NewToursSteps.selecionoOVooDeVolta(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "BOOK A FLIGHT",
      "offset": 15
    }
  ],
  "location": "NewToursSteps.estouNaTela(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "Blue Skies Airlines 361",
      "offset": 24
    },
    {
      "val": "Blue Skies Airlines 631",
      "offset": 52
    }
  ],
  "location": "NewToursSteps.validoOsDadosDeVooE(String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "Automacao",
      "offset": 33
    },
    {
      "val": "Teste",
      "offset": 46
    },
    {
      "val": "118989038904",
      "offset": 56
    }
  ],
  "location": "NewToursSteps.preenchoOsCamposObrigatoriosE(String,String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "FLIGHT CONFIRMATION",
      "offset": 15
    }
  ],
  "location": "NewToursSteps.estouNaTela(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "NewToursSteps.validoONumeroDeReserva()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 584857800,
  "status": "passed"
});
});