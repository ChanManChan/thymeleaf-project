chartData = JSON.parse(decodeHtml(chartData))

const labels = chartData.map(x => x.label)
const data = chartData.map(x => x.value)

new Chart(document.getElementById("myPieChart"), {
    type: 'pie',
    data: {
        labels,
        datasets: [{
            label: 'dataset',
            backgroundColor: ["#3e95cd", "#8e5ea2", "#3cba9f"],
            borderColor: 'rgb(255, 99, 132)',
            data
        }]
    },
    options: {
        title: {
            display: true,
            text: "Project Statuses"
        }
    }
})

// [{}, {}, {}]
// parse
// "[{&quot;value&quot;:1,&quot;label&quot;:&quot;COMPLETED&quot;},{&quot;value&quot...
function decodeHtml(html) {
    const txt = document.createElement("textarea");
    txt.innerHTML = html;
    return txt.value;
}