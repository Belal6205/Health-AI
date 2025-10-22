
**A smart, interactive nutrition and fitness assistant built with Scala 3**

*Personalized health guidance meets interactive learning*

</div>

## 🚀 Overview

GymRats Nutrition Bot is an intelligent command-line chatbot that provides personalized fitness guidance, nutrition education, and interactive quizzes. Built with functional programming principles in Scala, it helps users achieve their health goals through data-driven recommendations and engaging educational content.

## ✨ Features

### 🧠 **Interactive Quiz System**
- **Multiple Topics**: Nutrition-focused questions with immediate feedback
- **Smart Evaluation**: Handles both text and numeric answers
- **Performance Analytics**: Tracks quiz scores and identifies knowledge gaps

### 👤 **Personalized User Profiles**
- **Comprehensive Data Collection**: Name, age, height, weight, food preferences
- **BMI Calculation**: Automatic BMI computation with health insights
- **Goal-Oriented Planning**: Tailored recommendations based on user objectives

### 💪 **Smart Fitness Planning**
- **Weight Management**: Custom plans for weight loss/gain
- **Exercise Recommendations**: Cardio, strength training, and HIIT guidance
- **Nutritional Advice**: Caloric intake suggestions and dietary tips

### 📊 **Advanced Analytics**
- **Interaction Logging**: Complete session tracking
- **Performance Metrics**: Quiz accuracy and engagement statistics
- **Session Summaries**: Detailed end-of-session reports

## 🛠️ Tech Stack

- **Language**: Scala 3 (Functional Programming)
- **Paradigm**: Pure Functional with Immutable Data Structures
- **Patterns**: State Machine, Sealed Traits, Pattern Matching
- **Features**: Type Safety, Recursion, Higher-Order Functions

## 🏗️ Architecture

### Core Components

```scala
// State Management
sealed trait BotState
case object Greeting extends BotState
case object QuizInProgress extends BotState
// ... more states

// Data Models
case class UserProfile(
  name: String,
  age: Option[Int],
  height: Option[Int],
  weight: Option[Int],
  // ... other fields
)

// Logging System
sealed trait LogEntry
case class InteractionLog(...) extends LogEntry
case class QuizLog(...) extends LogEntry
```

### System Flow
1. **Greeting & Quiz Offer** → **Topic Selection** → **Interactive Quiz**
2. **User Profile Collection** → **Goal Identification** → **Personalized Plan**
3. **Continuous Logging** → **Analytics Generation** → **Session Summary**

## 🚀 Getting Started

### Prerequisites

- Scala 3.x
- sbt (Scala Build Tool)

### Installation & Running

1. **Clone the Repository**
   ```bash
   git clone https://github.com/your-username/gymrats-nutrition-bot.git
   cd gymrats-nutrition-bot
   ```

2. **Build and Run**
   ```bash
   sbt run
   ```

3. **Follow Interactive Prompts**
   ```
   💪 WELCOME TO GYMRATS NUTRITION BOT! 💪🔥
   ARE YOU READY TO TAKE THIS QUIZ? (Type 'yes' or 'no')
   > yes
   ```

### Project Structure
```
gymrats-nutrition-bot/
├── src/main/scala/
│   └── NutritionFitnessChatbot.scala
├── build.sbt
├── README.md
└── presentation/
    └── GYMRATS_Nutrition_Bot_Presentation.pdf
```

## 📖 Usage Examples

### 🎯 Quiz Interaction
```
Which vitamin is primarily obtained from sunlight?
1. Vitamin A
2. Vitamin C
3. Vitamin D
4. Vitamin K

Type your answer (e.g., vitamin d or 3): 
> 3
Correct! 🎉
```

### 📝 Personalized Planning
```
What do you want me to help you with?
Do you want to 'lose weight', 'gain weight', or 'nutrition advice'?
> lose weight

How many kilograms do you want to lose?
> 5

Here's a personalized Lose weight plan to help you reach 70 kg:
- Daily Caloric Intake: Reduce your intake by ~500 kcal/day.
- Hydration: At least 2 liters of water daily.
```

## 🧪 Testing Strategy

### Manual Testing Coverage
- ✅ Quiz logic and answer evaluation
- ✅ BMI calculation accuracy
- ✅ Input parsing and validation
- ✅ State transitions
- ✅ Edge case handling

### Error Handling
- **Invalid Inputs**: Graceful recovery with re-prompting
- **Missing Data**: Safe handling with Option types
- **Exit Management**: Clean session termination

## 📊 Analytics Features

### Session Summary
```
--- ANALYTICS ---
Total Interactions: 15
Regular Messages: 8
Quiz Messages: 7
Most Common: Quiz

Quiz Performance:
Correct: 5 / 7 (71%)
Frequently Missed Questions:
 - Which vitamin helps with iron absorption?
```

## 🎯 Project Highlights

### 🏆 Key Achievements
- **Modular Design**: Easy to extend with new features
- **Functional Excellence**: Pure functions and immutability
- **User Engagement**: Interactive and educational experience
- **Robust Architecture**: Comprehensive error handling

### 🔧 Technical Strengths
- **Type Safety**: Compile-time error prevention
- **Pattern Matching**: Elegant state management
- **Recursion**: Efficient input validation loops
- **Composition**: Modular function design

## 🚀 Future Enhancements

### Planned Features
- [ ] **Database Integration**: Persistent user profiles and progress tracking
- [ ] **Enhanced NLP**: Apache OpenNLP for better natural language understanding
- [ ] **Expanded Content**: Mental health, meal planning, and advanced fitness topics
- [ ] **Mobile App**: Kotlin Multiplatform or Scala.js frontend
- [ ] **AI Integration**: Machine learning for personalized recommendations
- [ ] **Social Features**: Progress sharing and community challenges

### Research Directions
- **Machine Learning**: Predictive health recommendations
- **Wearable Integration**: Sync with fitness trackers
- **Meal Planning**: Automated grocery lists and recipes
- **Progress Analytics**: Long-term trend analysis


### Development Setup
1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request


**💪 Empower Your Health Journey with GymRats Nutrition Bot! 🥗**

*Building healthier communities, one interaction at a time*

