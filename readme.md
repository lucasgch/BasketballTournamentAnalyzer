# Basketball Tournament Analyzer

Um sistema em Java desenvolvido para análise de desempenho em torneios de basquete, utilizando os princípios da **Programação Orientada a Objetos (POO)**. O projeto permite processar dados de partidas, times e jogadores para calcular pontuações, identificar cestinhas e determinar o MVP do torneio.

---

## Visão Geral do Projeto (Project Overview)

O **Basketball Tournament Analyzer** tem como objetivo modelar e analisar a performance de um torneio de basquete completo. Através do mapeamento das relações entre torneios, equipes, atletas e estatísticas individuais por jogo, a aplicação processa métricas em tempo real para gerar relatórios detalhados.

Este projeto foi construído utilizando uma **abordagem incremental**, onde cada classe e funcionalidade é desenvolvida e testada passo a passo para garantir a integridade dos dados e a consistência do modelo OO.

---

## Requisitos e Funcionalidades

A aplicação cumpre os seguintes requisitos analíticos:

* **Pontuação Individual:** Cálculo de pontos, rebonboard e assistências de cada jogador por partida.
* **Pontuação por Equipe:** Consolidação do placar final de cada jogo para comparação de desempenho entre times.
* **Resumo de Partidas (Game Summaries):** Geração de relatórios contendo times participantes, pontuação final, público pagante e métricas relevantes da partida.
* **Identificação de Cestinhas (Highest Scorers):**
* Maior pontuador de cada time por partida.
* Maior pontuador geral do torneio.


* **Estatísticas do MVP (Most Valuable Player):** Cálculo consolidado das estatísticas do jogador mais valioso da competição (total de jogos, pontos, rebotes e assistências).

---

## Arquitetura e Estrutura de Classes

A estrutura do sistema é composta por 5 classes principais que representam as entidades do domínio e seus relacionamentos:

1. **`Tournament`**: Representa o torneio como um todo. Contém as equipes, as partidas e a referência ao MVP.
2. **`Team`**: Representa uma equipe participante do torneio.
3. **`Player`**: Contém os dados dos atletas de cada equipe.
4. **`Game`**: Armazena as informações relativas a uma partida específica (placar, público, times).
5. **`PlayerGameStats`**: Registra o desempenho estatístico (pontos, rebotes, assistências) de um jogador em um jogo específico.

### Relacionamentos (UML)

```text
  +------------------+             +------------------+
  |    Tournament    | 1        *  |       Team       |
  |------------------|------------>|------------------|
  | - mvp: Player (1)|             | - players: List  |
  +--------+---------+             +------------------+
           |                                ^
           | 1                              | 2
           v *                              |
  +------------------+                      |
  |       Game       |----------------------+
  +--------+---------+
           | 1
           v *
  +------------------+             +------------------+
  | PlayerGameStats  |------------>|      Player      |
  +------------------+      *    1 +------------------+

```

* **Tournament ➔ Player (1 : 1):** Um torneio possui exatamente um jogador eleito como MVP.
* **Tournament ➔ Team (1 : *):** Um torneio possui múltiplos times participantes (no cenário atual, focado em 2 times).
* **Tournament ➔ Game (1 : *):** Um torneio é composto por várias partidas.
* **Game ➔ Team (1 : 2):** Cada partida é disputada por exatamente 2 equipes.
* **Game ➔ PlayerGameStats (1 : *):** Uma partida registra as estatísticas de múltiplos jogadores.

> **Premissa:** Para fins de simplificação, assume-se que todos os jogadores inscritos em um time participam de todas as partidas disputadas por sua equipe.

---

## Objetivos de Aprendizagem

Este projeto permitiu consolidar conceitos fundamentais do desenvolvimento em Java:

* Aplicação prática dos pilares de POO (Encapsulamento, Abstração e Associatividade).
* Design e modelagem de classes a partir de diagramas UML.
* Manipulação e processamento de dados e coleções em Java.
* Resolução de problemas e raciocínio algorítmico.
* Desenvolvimento e testes incrementais de software.

---

## Tecnologias Utilizadas

* **Linguagem:** Java (JDK 17+)
* **Paradigma:** Programação Orientada a Objetos (POO)
* **Ferramenta de Build / Execução:** Maven / Gradle ou Java CLI

---

## Como Executar o Projeto

1. **Clone o repositório:**
```bash
git clone https://github.com/lucasgch/basketball-tournament-analyzer.git
cd basketball-tournament-analyzer
```

2. **Compile as classes:**
```bash
javac -d bin src/*.java
```

3. **Execute a aplicação principal:**
```bash
java -cp bin Main
```

---

## Testes

O projeto conta com uma suíte de testes automatizados em **JUnit 5**, cobrindo os cálculos centrais do domínio:

* **Testes unitários** (`GameTest`, `TeamTest`, `PlayerGameTest`, `TournamentTest`): validam o cálculo de placar e vencedor da partida, o contrato de `equals`/`hashCode` de `Team`, a pontuação individual (`PlayerGameStats`) e os cálculos agregados do torneio (maior pontuador e vencedor).
* **Teste parametrizado via CSV** (`PlayerGameTest`): usa `@ParameterizedTest` + `@CsvFileSource` para validar `getPlayerGameScore()` contra várias linhas de estatísticas reais, carregadas de `src/test/resources/player-game-scores.csv`.

Para executar todos os testes:
```bash
./gradlew test
```

---

## Créditos e Fonte dos Dados

As estatísticas utilizadas neste projeto — incluindo os dados de teste em `src/test/resources/player-game-scores.csv` — foram obtidas manualmente do [Basketball Reference](https://www.basketball-reference.com/), a partir do box score do [Jogo 1 das Finais da NBA de 2001](https://www.basketball-reference.com/boxscores/200106060LAL.html) (Philadelphia 76ers x Los Angeles Lakers, 6 de junho de 2001).

Para estatísticas e dados mais detalhados, visite [basketball-reference.com](https://www.basketball-reference.com/). Consulte os [termos de uso](https://www.sports-reference.com/termsofuse.html) do Sports Reference para os usos permitidos dos dados.

---

*Projeto desenvolvido como desafio prático de Java e Programação Orientada a Objetos.*
