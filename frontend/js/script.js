const apiUrl = 'http://localhost:8080/filmes';

// Função para listar todos os filmes
async function listarFilmes() {
    const response = await fetch(apiUrl);
    const filmes = await response.json();
    const movieList = document.getElementById('movieList');
    movieList.innerHTML = '';  // Limpar lista antes de renderizar
    filmes.forEach(filme => {
        const li = document.createElement('li');
        li.innerHTML = `
            <div id="container-info">
                <strong>${filme.titulo}</strong><br>
                Diretor: ${filme.diretor}<br>
                Gênero: ${filme.genero}<br>
                Ano de Lançamento: ${filme.anoLancamento}<br>
                Classificação: ${filme.classificacao}<br>
                Sinopse: ${filme.sinopse}<br>
            </div>
            <div id="container-button">
                <button id="edit-button" onclick="prepararEdicao(${filme.id})">Editar</button>
                <button id="delete-button" onclick="deletarFilme(${filme.id})">Deletar</button>
            </div>
        `;
        movieList.appendChild(li);
    });
}

// Função para adicionar e editar um filme
document.getElementById('movieForm').addEventListener('submit', async (e) => {
    e.preventDefault(); // Prevenir o envio do formulário

    const filme = {
        titulo: document.getElementById('titulo').value,
        diretor: document.getElementById('diretor').value,
        genero: document.getElementById('genero').value,
        anoLancamento: document.getElementById('anoLancamento').value,
        classificacao: parseFloat(document.getElementById('classificacao').value),
        sinopse: document.getElementById('sinopse').value
    };

    if (filmeEditandoId) {
        // Caso for editar um filme
        await fetch(`${apiUrl}/${filmeEditandoId}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(filme)
        });
        filmeEditandoId = null; // Resetar o estado de edição
    } else {
        // Caso for adicionar um novo filme
        await fetch(apiUrl, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(filme)
        });
    }

    listarFilmes();  // Atualizar a lista de filmes
    document.getElementById('movieForm').reset();  // Limpar o formulário
});

let filmeEditandoId = null; // Armazena o ID do filme em edição

// Função para preparar o formulário para edição
async function prepararEdicao(id) {
    const response = await fetch(`${apiUrl}/${id}`);
    const filme = await response.json();

    // Preencher o formulário com os dados do filme
    document.getElementById('titulo').value = filme.titulo;
    document.getElementById('diretor').value = filme.diretor;
    document.getElementById('genero').value = filme.genero;
    document.getElementById('anoLancamento').value = filme.anoLancamento;
    document.getElementById('classificacao').value = filme.classificacao;
    document.getElementById('sinopse').value = filme.sinopse;

    // Salvar o ID do filme em edição
    filmeEditandoId = id;
}

// Função para deletar um filme
async function deletarFilme(id) {
    await fetch(`${apiUrl}/${id}`, {
        method: 'DELETE'
    });
    listarFilmes();  // Atualizar a lista após a exclusão
}

// Carregar os filmes ao iniciar a página
listarFilmes();