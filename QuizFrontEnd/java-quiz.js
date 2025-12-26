let questions = [];
let index = 0;
let score = 0;

window.onload = () => {
    questions = JSON.parse(localStorage.getItem("quizQuestions"));

    if (!questions) {
        alert("Quiz data missing");
        window.location.href = "index.html";
        return;
    }

    document.getElementById("total").innerText = questions.length;
    loadQuestion();
};

function loadQuestion() {
    const q = questions[index];

    document.getElementById("question").innerText = q.questionDes;
    document.getElementById("current").innerText = index + 1;

    const optionsDiv = document.getElementById("options");
    optionsDiv.innerHTML = "";

    q.options.forEach(opt => {
        const btn = document.createElement("button");
        btn.innerText = opt;
        btn.onclick = () => checkAnswer(opt);
        optionsDiv.appendChild(btn);
    });
}

function checkAnswer(selected) {
    if (selected === questions[index].correctAns) {
        score++;
    }
    nextQuestion();
}

function nextQuestion() {
    if (index < questions.length - 1) {
        index++;
        loadQuestion();
    } else {
        localStorage.setItem("quizScore", score);
        localStorage.setItem("totalQuestions", questions.length);
        window.location.href = "result.html";
    }
}
