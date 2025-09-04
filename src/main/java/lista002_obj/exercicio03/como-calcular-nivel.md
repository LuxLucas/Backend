Você pode usar a PokéAPI para obter todos os dados necessários para calcular o nível de um Pokémon, mas é importante entender que a API não retorna diretamente o nível — ela fornece informações como total de experiência (base_experience) e grupo de crescimento (growth_rate), e a partir disso você aplica a fórmula correta.

Aqui vai um passo a passo para fazer isso:
## 🔍 1. Obter os dados do Pokémon

Use o endpoint /pokemon/{nome_ou_id} para pegar informações básicas, incluindo a experiência base.

Exemplo em JavaScript:
 ```js
fetch("https://pokeapi.co/api/v2/pokemon/pikachu")
  .then(res => res.json())
  .then(data => {
    console.log("Experiência base:", data.base_experience);
    console.log("URL species:", data.species.url);
  });
 ```

## 📂 2. Descobrir o grupo de crescimento

O nível não é calculado só com `base_experience`. Você precisa saber o grupo de crescimento da espécie.

Para isso, use o endpoint `/pokemon-species/{nome_ou_id}`:
 ```js
fetch("https://pokeapi.co/api/v2/pokemon-species/pikachu")
  .then(res => res.json())
  .then(species => {
    console.log("Grupo de crescimento:", species.growth_rate.name);
  });
 ```

 ## 📈 3. Obter a tabela de crescimento
Cada grupo de crescimento tem uma curva de EXP diferente. Você pode consultar `/growth-rate/{id}` para pegar uma lista de níveis e a EXP necessária para cada um.

Exemplo:
```js
fetch("https://pokeapi.co/api/v2/growth-rate/2") // 2 = medium-fast
  .then(res => res.json())
  .then(growth => {
    console.log(growth.levels); // array com { level, experience }
  });
```

## 🧮 4. Calcular o nível
Com o total de EXP atual (que você teria que medir no jogo ou simular) e a tabela de crescimento obtida da API, basta encontrar o maior nível cujo valor de EXP seja menor ou igual ao EXP atual.

Exemplo de lógica:
```js
function calcularNivel(expAtual, tabela) {
  let nivel = 1;
  for (let i = 0; i < tabela.length; i++) {
    if (expAtual >= tabela[i].experience) {
      nivel = tabela[i].level;
    } else {
      break;
    }
  }
  return nivel;
}
```

## 💡 Resumo do fluxo:

- /pokemon/{id} → pega dados básicos e link para species

- /pokemon-species/{id} → pega o grupo de crescimento

- /growth-rate/{id} → pega a tabela de EXP por nível

- Compara EXP atual com a tabela → obtém o nível