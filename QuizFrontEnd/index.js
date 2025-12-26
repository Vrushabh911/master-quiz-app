async function startQuiz(category) {
    try {
        const res = await fetch(
            `http://localhost:8080/api/questions/category/${category}`
        );

        const data = await res.json();

        if (data.length === 0) {
            alert("No questions available");
            return;
        }

        localStorage.setItem("quizQuestions", JSON.stringify(data));
        localStorage.setItem("quizCategory", category);

        window.location.href = "java-quiz.html";
    } catch (err) {
        alert("Server not reachable");
    }
}
