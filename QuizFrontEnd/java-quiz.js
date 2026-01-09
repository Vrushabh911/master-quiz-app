/**
 * Global Quiz State
 */
let questions = [];
let index = 0;
let score = 0;

/**
 * 1. INITIALIZATION
 * This is called by the HTML script once the Backend 
 * confirms the user is logged in and data is fetched.
 */
function startQuizInitialization() {
    console.log("🚀 Initializing Quiz Logic...");
    const data = localStorage.getItem("quizQuestions");
    
    if (!data) {
        console.error("❌ No quiz data found in storage!");
        window.location.href = "index.html";
        return;
    }

    questions = JSON.parse(data);
    
    // Set UI Counters
    document.getElementById("total").innerText = questions.length;
    
    // Set Dynamic Title (Java, Python, etc.)
    const category = localStorage.getItem("currentQuiz") || "java";
    document.getElementById("quiz-title").innerText = category.toUpperCase() + " QUIZ";
    
    loadQuestion();
}

/**
 * 2. LOAD QUESTION
 * Renders the current question and generates option buttons.
 */
function loadQuestion() {
    const q = questions[index];
    
    // Update Text and Progress
    document.getElementById("question").innerText = q.questionDes;
    document.getElementById("current").innerText = index + 1;
    
    // Clear old buttons
    const optionsDiv = document.getElementById("options");
    optionsDiv.innerHTML = "";
    
    // Generate new buttons
    q.options.forEach((opt) => {
        const btn = document.createElement("button");
        btn.innerText = opt;
        btn.className = "quiz-option"; 
        btn.onclick = () => checkAnswer(opt, btn);
        optionsDiv.appendChild(btn);
    });
}

/**
 * 3. CHECK ANSWER
 * Provides instant visual feedback and updates score.
 */
function checkAnswer(selected, clickedBtn) {
    const correct = questions[index].correctAns;
    const buttons = document.querySelectorAll(".quiz-option");
    
    // Disable all buttons to prevent multiple clicks
    buttons.forEach(btn => btn.disabled = true);
    
    if (selected === correct) {
        // Correct Answer Styling
        clickedBtn.style.backgroundColor = "#28a745"; // Success Green
        clickedBtn.style.color = "white";
        clickedBtn.style.borderColor = "#1e7e34";
        score++;
    } else {
        // Wrong Answer Styling
        clickedBtn.style.backgroundColor = "#dc3545"; // Error Red
        clickedBtn.style.color = "white";
        
        // Highlight the correct answer for the user
        buttons.forEach(btn => {
            if (btn.innerText === correct) {
                btn.style.backgroundColor = "#28a745";
                btn.style.color = "white";
            }
        });
    }
    
    // Automatic transition after 1.5 seconds
    setTimeout(nextQuestion, 1500);
}

/**
 * 4. NAVIGATION
 * Moves to next question or redirects to results.
 */
function nextQuestion() {
    if (index < questions.length - 1) {
        index++;
        loadQuestion();
    } else {
        // Save results for result.html
        localStorage.setItem("quizScore", score);
        localStorage.setItem("totalQuestions", questions.length);
        window.location.href = "result.html";
    }
}

/**
 * 5. LOGOUT (Optional Utility)
 * Redirects to the Spring Boot logout endpoint.
 */
function logout() {
    localStorage.clear();
    window.location.href = "http://localhost:8080/logout";
}