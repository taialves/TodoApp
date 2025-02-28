# 📌 Relatório do Projeto - Agenda Acadêmica

## 📖 Visão Geral  
O projeto **Agenda Acadêmica** é um aplicativo para gerenciar atividades acadêmicas. Ele permite que os usuários adicionem, editem e removam tarefas, além de visualizar detalhes adicionais ao expandir um item na lista.

---

## 🚀 Funcionalidades Principais  

✔️ Adicionar novas atividades acadêmicas  
✔️ Definir nome, descrição, responsável e horário  
✔️ Expandir e recolher detalhes da atividade  
✔️ Excluir atividades cadastradas  
✔️ Interface moderna com **Bottom Sheet Dialog** para cadastro  

---

## 📂 Estrutura do Código  

### 📌 **Arquivos e Classes Principais**  

- **`MainActivity.kt`** → Atividade principal do app, gerencia a RecyclerView.  
- **`NovaAtividade.kt`** → Tela de cadastro/edição de tarefas usando um BottomSheetDialog.  
- **`AtividadeViewModel.kt`** → Gerencia os dados das tarefas usando **LiveData**.  
- **`ItemAtividade.kt`** → Modelo de dados das atividades.  
- **`ItemAtividadeAdapter.kt`** → Adapta os dados para a RecyclerView.  
- **`ItemAtividadeViewHolder.kt`** → Gerencia a exibição de cada item na lista.  
- **`TaskItemClickListener.kt`** → Interface para cliques em itens da RecyclerView.  

---

## 🔄 Fluxo de Funcionamento  

1️⃣ **Usuário clica no botão "Nova Atividade"**  
2️⃣ **Bottom Sheet Dialog aparece** com campos de preenchimento  
3️⃣ **Usuário salva a atividade**, que aparece na lista  
4️⃣ **Usuário pode expandir/recolher detalhes** ao tocar no item  
5️⃣ **Usuário pode excluir uma atividade** clicando no botão vermelho  

---

## 🖼️ Capturas de Tela  

### 📌 **Tela de Cadastro**  
![Nova Atividade](https://github.com/taialves/TodoApp/blob/TodoApp/novatarefa.png)

### 📌 **Tela de Listagem**  
![Lista de Atividades](https://github.com/taialves/TodoApp/blob/TodoApp/lista.png)

---

## 📌 Conclusão  

O **Agenda Acadêmica** é um aplicativo funcional que permite um gerenciamento eficiente de atividades. Ele foi desenvolvido utilizando **Kotlin, Android ViewModel e RecyclerView**, com um design limpo e intuitivo.  


📌 **Desenvolvido por:** Tailson Alves  
📅 **Última atualização:** 27/02/2025  
