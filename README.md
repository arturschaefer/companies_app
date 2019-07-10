# Companies App

O aplicativo realiza o login após inserção de um e-mail e senha válidos. 
Dentro do app é possível buscar por empresas através do nome.
Ao clicar em uma empresa, direciona para uma tela com detalhes da mesma.

## Arquitetura

Utilizou-se o VIPER como arquitetura do projeto. 
Seguindo como guideline o artigo [Arquitetura limpa nas apps: utilizando VIPER no Android](https://medium.com/android-dev-br/arquitetura-limpa-nas-apps-utilizando-viper-no-android-f39e51b44723).

### Pré-requisitos

* SDK miníma do Android: 21 
* Conexão com internet para consumo da API

### Instalação

A versão da APK está disponível para download na parte de releases.

## Bibliotecas principais

* [Retrofit](https://github.com/square/retrofit) - Cliente HTTP para requisições
* [Glide](https://github.com/bumptech/glide) - Gerenciment e carregamento de imagens
* [Logger](https://github.com/orhanobut/logger) - Uma melhoria dos Logs do Android
* [Dagger2](https://github.com/google/dagger) - Injeção de dependências
* [RxJava](https://github.com/ReactiveX/RxJava) - Implementa programação reativa
* [Loggin Interceptor](https://github.com/square/okhttp/tree/master/okhttp-logging-interceptor) - Log de requisições HTTP
* [Transition Everywhere](https://github.com/andkulikov/Transitions-Everywhere) - Gerenciamento de transições e animações
* [MaterialSearchView](https://github.com/MiguelCatalan/MaterialSearchView) - Implementação da SearchView do Material Design 

## Melhorias futuras

* Implementação de testes
* Tratamento de erros de conexão e outros que possam retornar do backend
* Exibir loadings animados enquanto espera chamadas do backend, visando aumentar feedback visual ao usuário
