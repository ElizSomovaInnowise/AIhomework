function calculateExpenses() {
    const table = document.getElementById('expenseTable');
    const rows = table.getElementsByTagName('tbody')[0].getElementsByTagName('tr');
    let total = 0;
    let expenses = [];

    for (let i = 0; i < rows.length; i++) {
        const amount = parseFloat(rows[i].getElementsByTagName('td')[1].textContent);
        total += amount;
        expenses.push(amount);
    }

    const average = total / 30;
    expenses.sort((a, b) => b - a);
    const top3 = expenses.slice(0, 3);

    document.getElementById('total').textContent = total.toFixed(2) + ' $';
    document.getElementById('average').textContent = average.toFixed(2) + ' $';
    document.getElementById('top3').textContent = top3.join(', ');
} 