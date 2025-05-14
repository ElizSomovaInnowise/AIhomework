document.addEventListener('DOMContentLoaded', function() {
    const appDiv = document.getElementById('app');
    appDiv.innerHTML = '<p>Welcome to the Expense Calculator!</p>';
});

document.getElementById('calculateButton').addEventListener('click', function() {
    const rows = document.querySelectorAll('#expenseTable tr');
    let total = 0;
    const expenses = [];

    rows.forEach((row, index) => {
        if (index === 0) return; 
        const cells = row.querySelectorAll('td');
        const category = cells[0].textContent;
        const amount = parseFloat(cells[1].textContent);
        total += amount;
        expenses.push({ category, amount });
    });

    const average = total / 30;
    expenses.sort((a, b) => b.amount - a.amount);
    const top3 = expenses.slice(0, 3);

    const resultsDiv = document.getElementById('results');
    resultsDiv.innerHTML = `
        <p>Total amount of expenses: $${total}</p>
        <p>Average daily expense: $${average.toFixed(2)}</p>
        <p>Top 3 expenses: ${top3.map(e => `${e.category} ($${e.amount})`).join(', ')}</p>
    `;
});

document.getElementById('expenseForm').addEventListener('submit', function(event) {
    event.preventDefault();
    const category = document.getElementById('categoryInput').value;
    const amount = parseFloat(document.getElementById('amountInput').value);
    if (category && !isNaN(amount)) {
        const table = document.getElementById('expenseTable');
        const newRow = table.insertRow();
        const categoryCell = newRow.insertCell(0);
        const amountCell = newRow.insertCell(1);
        categoryCell.textContent = category;
        amountCell.textContent = amount;
        document.getElementById('categoryInput').value = '';
        document.getElementById('amountInput').value = '';
    }
}); 