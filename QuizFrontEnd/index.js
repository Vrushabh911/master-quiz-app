async function startQuiz(category) {
    try {
        console.log("🔥 Starting", category.toUpperCase(), "quiz...");
        
        const response = await fetch(`http://localhost:8080/api/questions/${category}`, {
            method: 'GET',
            credentials: 'include', 
            headers: { 'Accept': 'application/json' }
        });

        // If the backend sends 401 (Unauthorized), redirect the user to the login page
        if (response.status === 401) {
            console.warn("❌ Session expired or not logged in. Redirecting...");
            window.location.href = 'http://localhost:8080/login';
            return;
        }

        if (!response.ok) {
            throw new Error(`Server responded with ${response.status}`);
        }

        const questions = await response.json();
        
        if (!questions || questions.length === 0) {
            alert(`No ${category} questions found!`);
            return;
        }

        localStorage.setItem('quizQuestions', JSON.stringify(questions));
        localStorage.setItem('currentQuiz', category);
        window.location.href = 'java-quiz.html';
        
    } catch (error) {
        console.error('❌ Connection error:', error);
        // This only triggers if the server is DOWN or there is a network error
        alert('Server unreachable. Please ensure the Spring Boot backend is running on port 8080.');
    }
}