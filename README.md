# Arena IA

Aplicativo Android simples em Kotlin para abrir rapidamente o Arena Text no navegador padrão.

## Escopo da versão 1.0

- Tela inicial dedicada com botão para abrir `https://arena.ai/text`.
- Usa o navegador padrão para preservar a compatibilidade com login, cookies e recursos dinâmicos do site.
- Não coleta credenciais nem implementa API própria.
- Build automatizado do APK de depuração pelo GitHub Actions.

> Este aplicativo é um atalho pessoal e independente; não é oficial nem afiliado à Arena.

## Build

Requisitos: JDK 17, Android SDK (API 35) e Gradle 8.9.

```bash
gradle --no-daemon assembleDebug
```

APK gerado em:

```
app/build/outputs/apk/debug/app-debug.apk
```

Também é possível baixar o artefato `arena-ia-debug-apk` na execução bem-sucedida do workflow **Android CI**.
