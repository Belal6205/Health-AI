# GymRats Nutrition & Fitness Chatbot

A Scala 3 command-line chatbot that provides users with nutrition advice, fitness recommendations, personalized plans, and a fun nutrition quiz. The chatbot maintains user profiles, logs interactions, and generates analytics at the end of each session.

## Features

- **Conversational Interface:** Friendly prompts and responses.
- **Quiz Mode:** Test your nutrition knowledge with a multiple-choice quiz.
- **User Profile:** Collects user info (name, gender, age, height, weight, food preferences).
- **Personalized Plans:** Offers advice on losing weight, gaining weight, or general nutrition. Calculates BMI and gives dietary/exercise suggestions.
- **Logging & Analytics:** Tracks all interactions and quiz results, and summarizes your session at the end.
- **Graceful Exit:** Type `exit` at any prompt to quit the chatbot safely.

## Getting Started

### Prerequisites

- Scala 3 (or Scala 2.13+ should work with minor tweaks)
- SBT (Scala Build Tool)

### Setup

1. **Clone or Download the Repo.**
2. Place the chatbot code in `src/main/scala/NutritionFitnessChatbot.scala`.
3. Your project structure should look like:
   ```
   .
   ├── build.sbt
   └── src
       └── main
           └── scala
               └── NutritionFitnessChatbot.scala
   ```

4. (Optional) Add the following to your `build.sbt` for Scala 3:
   ```scala
   scalaVersion := "3.3.1"
   scalacOptions += "-deprecation"
   ```

### Running the Chatbot

From the project root, run:

```sh
sbt run
```

Then follow the on-screen instructions!  
Type `exit` at any time to leave the chatbot.

## Project Structure

- **NutritionFitnessChatbot.scala**  
  Contains the entire application: state management, user profile, quiz logic, recommendations, and analytics.

## Customization

Feel free to:
- Add more quiz topics and questions in `selectQuizQuestions`.
- Enhance the nutrition and fitness advice rules.
- Improve user profile fields or analytics.

## Teamwork

This project is modular! You can assign teammates to:
- Conversation state management (main loop)
- Quiz logic and evaluation
- User profile and analytics
- Nutrition/fitness plan and recommendations

## Example Interaction

```
💪 WELCOME TO GYMRATS NUTRITION BOT! 💪🔥
ARE YOU READY TO TAKE THIS QUIZ? 💪🧐 (Type 'yes' or 'no')
> yes
GOOOD! It seems you are ready for the quiz! 🥳
What topic would you like to take the quiz on? (Only: nutrition, or 'exit')
> nutrition
Great! You've chosen the Nutrition quiz. Let's begin! 🚀
Which vitamin is primarily obtained from sunlight?
1. Vitamin A
2. Vitamin C
3. Vitamin D
4. Vitamin K
Type your answer (e.g., vitamin d): (Type 'exit' to quit)
> vitamin d
Correct! 🎉
...
```

## License

MIT
