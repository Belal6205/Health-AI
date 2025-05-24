import scala.io.StdIn._
def readMessage(input: String): Unit = {
  val message = input.split(" ").map(_.trim).toList

  def findKeyWord(words: List[String]): Unit = {
    val nutritionKeywords = List(
      "nutrition advice", "get nutrition advice", "nutrition plan", "diet advice", "healthy eating advice", "meal plan advice",
      "nutrition guide", "dietary advice", "healthy food tips", "balanced diet advice", "meal guidance", "eating guidance",
      "meal suggestions", "nutritional tips", "nutrition tips", "diet tips", "food advice", "nutritional information",
      "healthy eating tips", "meal recommendations", "weight loss advice", "dietary information", "nutrient tips",
      "nutrition help", "calorie intake advice", "meal recommendations", "food guidance", "eating tips", "nutrition support",
      "food guide", "calories advice", "meal suggestions", "nutrition planning", "weight gain advice", "healthy meal plan",
      "food recommendations", "nutrient guide", "balanced meal plan", "nutrition for weight loss", "weight control advice",
      "nutritional guidance", "meal tips", "nutritional coaching", "food preparation advice", "nutrient breakdown",
      "food intake advice", "macro recommendations", "micronutrient advice", "calorie recommendations", "meal planning help",
      "nutrition facts", "macro tips", "portion control advice", "weight loss guidance", "healthy food recommendations"
    )

    val nutritionMisspellings = List(
      "nitrition", "nutriton", "nutritiion", "nutrion", "nutriiton", "nutritoin", "nutriotion", "nutrition adivce", "nutrition advise", "nutriton advice",
      "nutition", "nutriiton", "nutrittion", "nutriition", "nutriation", "nutrittion", "nutriiton", "nutritoin", "nutriion advice", "nutritiion adivce",
      "nutriton", "nutriton plan", "nutrition advcice", "nutrittion advice", "nutrittion tips", "nutrition adice", "nutriton tips", "nutriton help", "nutriton planning"
    )

    val quizKeywords = List(
      "nutrition quiz", "take a nutrition quiz", "nutrition test", "nutrition assessment", "diet quiz", "diet test", "food quiz", "eating quiz", "meal quiz",
      "nutrient quiz", "nutrition knowledge test", "dietary quiz", "food knowledge test", "weight loss quiz", "macro quiz", "calorie quiz", "nutritional assessment",
      "healthy food quiz", "weight gain quiz", "nutritional knowledge quiz", "balanced diet quiz", "fitness quiz", "nutrition score", "health quiz", "food survey",
      "nutrition check", "food survey quiz", "calories quiz", "nutrition challenge", "dietary test", "nutrition check-up", "dietary knowledge test", "macro assessment",
      "nutrient test", "nutrition questionnaire", "food challenge", "weight control quiz", "meal assessment", "nutrition skill test", "nutrition evaluation",
      "food habits quiz", "fitness assessment quiz", "body fat quiz", "diet analysis", "weight loss assessment", "food intake test", "healthy eating challenge",
      "healthy eating quiz", "nutrition strategy quiz", "healthy habits quiz", "nutrition feedback"
    )

    val quizMisspellings = List(
      "nutrtion quiz", "nutriton quiz", "nutrition quize", "nutri quiz", "nutition quiz", "nutrition quz", "nutriton quiz", "nutriotion quiz", "nutrition qiz",
      "nutri quiz", "nutriton quize", "nutritin quiz", "nutriton test", "nutriton challenge", "nutritio quiz", "nutritiion test", "nutrittion quiz", "nutrittion quize",
      "nutriotn quiz", "nitrition quiz", "nutriton quiz", "nutri quiz", "nutriton assesment", "nutriton feedback", "nutritioanl quiz", "nutriotn quizz",
      "nutrition checkup", "nutrition assesment", "nutriton assesment", "nutritio quiz", "nutrittion quize", "nutrition quz", "nutri quiz"
    )

    val gainWeightKeywords = List(
      "gain weight", "bulk", "muscle gain", "gain muscle", "weight gain", "bulking", "put on weight", "increase muscle", "increase weight",
      "muscle building", "bulk up", "weight gain plan", "muscle growth", "bulk weight", "strength gain", "build muscle", "bulking diet", "weight increase",
      "muscle mass", "high calorie diet", "muscle weight gain", "calorie surplus", "fat gain", "mass gain", "weight bulking", "high calorie meal",
      "calorie gain", "build strength", "strength training", "muscle bulking", "weight training", "muscle size", "muscle mass increase", "weight lifting",
      "bulk plan", "bodybuilding diet", "muscle building program", "weight gaining diet", "high protein diet", "bodybuilding plan", "muscle bulking tips",
      "bulking routine", "muscle mass diet", "calorie gain plan", "strength diet", "muscle gain tips", "fat mass", "muscle size increase", "strength program",
      "bulking nutrition", "protein intake", "muscle training"
    )

    val gainWeightMisspellings = List(
      "gane weight", "gian weight", "gainweigth", "gainwight", "weight gain", "bulk gain", "gane weight", "gaining weight", "weight bulking", "muscle bulk",
      "weight gain", "gainweigth", "gainwight", "weight gain", "gain muscles", "muscle bulking", "weight gainning", "bulk up weight", "gain bulking",
      "muscle gaining", "muslce gain", "bulking diet", "gaining weight", "bulking intake", "muscle increase", "strength bulking", "weight training gain",
      "muscle mass bulking", "muscle gain", "bulking protein", "bodybuilding bulking", "weight lifting", "protein increase", "calorie bulking",
      "muscle bulking plan", "fat bulking", "muscle bulking up", "weight building", "bulk eating", "bulking weight plan", "gain weight muscle"
    )

    val loseWeightKeywords = List(
      "lose weight", "cut weight", "weight loss", "fat loss", "cutting", "lose fat", "slim down", "reduce weight", "shed pounds", "fat burning",
      "cutting diet", "fat burning plan", "diet for weight loss", "weight reduction", "slim down plan", "lose belly fat", "fat burning workout",
      "cut down", "weight cutting", "lose fat quickly", "weight loss tips", "burn fat", "lose body fat", "cut down calories", "fat loss plan",
      "weight reduction diet", "reduce fat", "calories deficit", "slim fast", "fat burning diet", "cut fat", "burn calories", "weight loss program",
      "calorie reduction", "fat loss workout", "cutting phase", "weight loss plan", "slim diet", "reduce belly fat", "cut body fat",
      "fast weight loss", "slim body", "lose weight fast", "calorie cutting", "burn fat", "quick weight loss", "cut fat quickly", "weight loss guide",
      "weight control"
    )

    val loseWeightMisspellings = List(
      "los weight", "losing weight", "losing wight", "cut down weight", "cutting weight", "losing weigt", "loose weight", "los wight",
      "losing wight", "weight losse", "losing weigh", "losing fat", "losign weight", "los weight fast", "losign wight", "cut down fat",
      "lose weigth", "lose wight", "losse weight", "loseing fat", "lose down weight", "slimming weight", "los weight", "cut wight",
      "loose wight", "losseing fat", "cutting wight"
    )

    val trainingPlanKeywords = List(
      "generate training plan", "training plan", "workout plan", "exercise plan", "fitness plan", "training routine", "personal training", "fitness routine",
      "workout program", "muscle training plan", "strength plan", "strength workout", "exercise routine", "fitness schedule", "workout schedule",
      "personal workout", "exercise schedule", "weight training plan", "bodybuilding plan", "muscle building workout", "strength workout plan",
      "training program", "muscle workout plan", "cardio routine", "exercise program", "muscle training schedule", "workout routine", "fitness program",
      "athlete training", "cardio workout", "muscle building plan", "workout calendar", "training calendar", "strength building plan", "fitness regime",
      "endurance training", "strength training schedule", "weight lifting program", "fitness coach", "muscle fitness plan", "muscle development plan",
      "athletic workout", "fitness diet", "strength building workout", "muscle workout", "strength workout program", "personalized workout",
      "muscle development", "athletic training"
    )

    val trainingPlanMisspellings = List(
      "generate traning plan", "generate workout plan", "generate fitness plan", "training generating plan", "generate work out plan",
      "generat workout plan", "training generate", "fitness workout plan", "personal workout plan", "generate trainning",
      "training work out", "workout generating", "generate excersize plan", "generate workout", "training plan program",
      "workout generat", "fitnes plan", "muscle generating plan", "workout generation", "personal workout", "training generat",
      "training plan generation", "work out training", "generate muslce training", "generate excersize", "generate work out schedule",
      "generat workout plan", "exercise generat plan", "plan workout generating"
    )

    words match {
      case Nil => println("Didn't get that.")
      case head :: tail if nutritionKeywords.exists(head.contains) || nutritionMisspellings.exists(head.contains) =>
        println("Nutrition selected.")
        handleNutritionAdvice()
      case head :: tail if quizKeywords.exists(head.contains) || quizMisspellings.exists(head.contains) =>
        println("Quiz selected.")
        handleQuiz()
      case head :: tail if gainWeightKeywords.exists(head.contains) || gainWeightMisspellings.exists(head.contains) =>
        println("Bulking selected.")
        handleWeightGoal("bulk", input)
      case head :: tail if loseWeightKeywords.exists(head.contains) || loseWeightMisspellings.exists(head.contains) =>
        println("Cutting selected.")
        handleWeightGoal("cut", input)
      case head :: tail if trainingPlanKeywords.exists(head.contains) || trainingPlanMisspellings.exists(head.contains) =>
        println("Training selected.")
        generateTrainingPlan()
      case head :: _ if head.contains("exit") =>
        println("Goodbye!")
        System.exit(0)
      case _ =>
        println("Didn't get that.")
    }
  }
  findKeyWord(message)
}
 def handleNutritionAdvice(input:String=""): Unit = {
  println("Choose a category (Veggies, Hydration, Protein, Carbs, Fats):")                     
  val categoryInput = readLine().capitalize
  val category = categoryInput match{
  case "Veggies" | "Vegetables" | "Veggie" |"Veges" | "Vegis" | "Veggis" | "Veges" | "Veggis" | "Vegitable" | "Vegees" | "Vegeis" | "Vegtables" | "Vegitables" => "Veggies"   
    case "Hydration" | "Water" |"Hydraton" | "Hydratin" | "Hydratoin" | "Hydratoinn" | "Hidration" |"Hydartion" | "Hydratien" | "Hydretian" | "Hydrotion" | "Hydrotionn" => "Hydration" 
    case "Protein" | "Proteins" |"Protin" | "Protean" | "Proteen" | "Proten" | "Proteein" | "Proteinn" | "Prottin" | "Protinse" | "Prottein" | "Protien" => "Protein" 
    case "Carbs" | "Carbohydrates" | "Carbo" | "Carbes" | "Carbos" | "Carbhydrate" | "Carbohidrates" | "Karbs" | "Carbohyrates" | "Carbohydrats" | "Carbhidrates" | "Carbohydratse" => "Carbs" 
    case "Fats" | "Fat" |"Faats" | "Fetts" | "Fatts" | "Fattses" | "Phats" |"Fatz" | "Fatzz" | "Fatsz" | "Fattes" | "Fatzes" => "Fats" 
    case _ => "Unknown" 
  }       
  }          
def showTipsByCategory(category: String): Unit = {
  category match {
    case "Veggies" =>
      println("🥦 Veggie Tips:")
      println("- Eat a variety of colors to maximize vitamin intake.")
      println("- Dark leafy greens like spinach are rich in iron and calcium.")
      println("- Steamed vegetables retain more nutrients than boiled ones.")
      println("- Add veggies to omelets, soups, and smoothies for easy boosts.")
      println("- Frozen vegetables are often just as nutritious as fresh.")
    case "Hydration" =>
      println("💧 Hydration Tips:")
      println("- Aim for 6–8 glasses of water daily.")
      println("- Drink more during hot weather or intense workouts.")
      println("- Start your day with a glass of water.")
      println("- Herbal teas and fruits with high water content help hydration.")
      println("- Avoid sugary drinks and sodas as hydration sources.")
    case "Protein" =>
      println("🍗 Protein Tips:")
      println("- Include protein in every meal to support muscle maintenance.")
      println("- Good sources: chicken, fish, tofu, beans, lentils, eggs.")
      println("- Protein helps you feel full longer.")
      println("- Post-workout protein boosts muscle recovery.")
      println("- Rotate plant and animal protein for a balanced diet.")
    case "Carbs" =>
      println("🍞 Carbohydrate Tips:")
      println("- Choose complex carbs like whole grains and legumes.")
      println("- Avoid refined sugars and processed white flour.")
      println("- Carbs are the body’s primary energy source.")
      println("- Don't skip carbs—just choose healthy ones in moderation.")
      println("- Pair carbs with protein or fat to control blood sugar spikes.")
    case "Fats" =>
      println("🥑 Healthy Fat Tips:")
      println("- Focus on unsaturated fats like olive oil, nuts, and seeds.")
      println("- Omega-3 fats from fish support heart and brain health.")
      println("- Avoid trans fats and limit saturated fats.")
      println("- Fat helps absorb fat-soluble vitamins (A, D, E, K).")
      println("- Avocados are a great source of healthy monounsaturated fat.")
    case _ =>  println("⚠️ Sorry, no tips available for that category. Try: Veggies, Hydration, Protein, Carbs, or Fats.")
  }
}
def handleQuiz(input: Int = 0): Unit = {
  val quizQuestions = List(
    ("Which nutrient is important for muscle growth?", List("Protein", "Fat", "Carbohydrate"), "Protein"),
    ("How many glasses of water should adults drink daily?", List("2-4", "6-8", "10-12"), "6-8"),
    ("What vitamin is mainly obtained from sunlight?", List("Vitamin C", "Vitamin D", "Vitamin A"), "Vitamin D"),
    ("Which mineral is important for bone health?", List("Iron", "Calcium", "Potassium"), "Calcium"),
    ("What macronutrient is the body’s main energy source?", List("Carbohydrate", "Protein", "Fat"), "Carbohydrate"),
    ("Which food is a good source of healthy fat?", List("Avocado", "White bread", "Candy"), "Avocado"),
    ("How many meals a day is ideal for stable energy?", List("1", "3", "7"), "3"),
    ("Which nutrient helps with oxygen transport?", List("Iron", "Calcium", "Vitamin C"), "Iron"),
    ("Which is best post-workout nutrition?", List("Protein shake", "Soda", "Chips"), "Protein shake"),
    ("What’s the healthiest drink choice?", List("Water", "Energy drink", "Cola"), "Water")
  )
  println("Welcome to the Nutrition Quiz!")
  println("Would you like to take a 5-question or 10-question quiz?")
  val numQuestionsStr = if (input == 0) scala.io.StdIn.readLine().trim.toLowerCase else input.toString
  val numQuestions = numQuestionsStr match {
    case x if List("10", "ten", "tne", "tn", "teb", "tem", "t3n", "txn", "tne.", "tnn", "teh").contains(x) => 10
    case x if List("5", "five", "fiev", "fve", "fiv", "fibe", "fie", "fi5e", "fiv3", "fvee", "fivw").contains(x) => 5
    case _ =>
      println("Invalid input, defaulting to 5-question quiz.")
      5
  }
  def printOptions(options: List[String], index: Int = 0): Unit = options match {
    case Nil => ()
    case head :: tail =>
      println(s"  ${('a' + index).toChar}) $head")
      printOptions(tail, index + 1)
  }
  def findAnswerByChar(options: List[String], ch: Char, index: Int = 0): String = options match {
    case Nil => "Invalid"
    case head :: tail =>
      if (ch == ('a' + index).toChar) head
      else findAnswerByChar(tail, ch, index + 1)
  }
  def startQuiz(
      questions: List[(String, List[String], String)],
      remaining: Int,
      index: Int = 0,
      score: Int = 0,
      answers: List[(String, String, String)] = List()
  ): (Int, List[(String, String, String)]) = {
    remaining match {
      case 0 => (score, answers)
      case _ =>
        val (question, options, correct) = questions(index)
        println(s"\n$question")
        printOptions(options)
        val answer = scala.io.StdIn.readLine().trim.toLowerCase
        val userAnswerText = answer match {
          case a if a.length == 1 && a.head >= 'a' && a.head < ('a' + options.length).toChar =>
            findAnswerByChar(options, a.head)
          case _ => "Invalid"
        }
        val updatedAnswers = answers :+ (question, userAnswerText, correct)
        userAnswerText match {
          case a if a == correct =>
            println("✅ Correct!")
            startQuiz(questions, remaining - 1, index + 1, score + 1, updatedAnswers)
          case _ =>
            println(s"❌ Incorrect. The correct answer is: $correct")
            startQuiz(questions, remaining - 1, index + 1, score, updatedAnswers)
        }
    }
  }
  val selectedQuestions = quizQuestions.take(numQuestions)
  val (score, userAnswers) = startQuiz(selectedQuestions, numQuestions)
  println(s"\nYou scored $score out of $numQuestions.")
  val percentage = (score.toDouble / numQuestions) * 100
  val gymType = percentage match {
    case p if p >= 90 => "🏆 Professional Bodybuilder Instructor"
    case p if p >= 70 => "💪 Gym Bro"
    case p if p >= 50 => "🏋️ Gym Rat"
    case _            => "🦴 Skinny"
  }
  println(s"\n💪 Based on your score, your gym type is: $gymType")
  println("\n📋 Your answers:")
  def printAnswers(answers: List[(String, String, String)], i: Int = 1): Unit = answers match {
    case Nil => ()
    case (question, userAnswer, correctAnswer) :: tail =>
      val status = userAnswer match {
        case a if a == correctAnswer => "✅ Correct"
        case _ => s"❌ Incorrect (Correct: $correctAnswer)"
      }
      println(s"$i. $question\n   Your answer: $userAnswer\n   $status")
      printAnswers(tail, i + 1)
  }
  printAnswers(userAnswers)
}
def handleWeightGoal(goalInput: String = "", input: String): String = {
  def messageReader(input: String, userDetails: Map[String, String]): (String, Map[String, String]) = {
    val lower = input.toLowerCase.split("[\\s,]+").toList
    def extract(details: Map[String, String], tokens: List[String]): Map[String, String] = tokens match {
      case Nil => details
      case head :: tail =>
        val updated = head match {
          case h if h.matches("\\d{2}") && !details.contains("age") => details + ("age" -> h)
          case h if h.matches("\\d{2,3}") && lower.contains("height") && !details.contains("height") => details + ("height" -> h)
          case h if h.matches("\\d{2,3}") && lower.contains("weight") && !details.contains("weight") => details + ("weight" -> h)
          case "bulking" if !details.contains("goal") => details + ("goal" -> "bulking")
          case "cutting" if !details.contains("goal") => details + ("goal" -> "cutting")
          case "male" | "female" if !details.contains("gender") => details + ("gender" -> head)
          case "low" | "medium" | "high" if !details.contains("activityLevel") => details + ("activityLevel" -> head)
          case "ectomorph" | "mesomorph" | "endomorph" if !details.contains("bodyType") => details + ("bodyType" -> head)
          case _ => details
        }
        extract(updated, tail)
    }
    val finalDetails = extract(userDetails, lower)
    val expectedKeys = List("goal", "weight", "age", "height", "activityLevel", "gender", "bodyType")
    val missing = expectedKeys.filterNot(finalDetails.contains)
    if (missing.isEmpty)
      ("All information is gathered. Now, let's proceed with your personalized plan.", finalDetails)
    else
      (s"Missing info: ${missing.mkString(", ")}. Could you provide those details?", finalDetails)
  }
  def extractUserInfoFromText(input: String): (String, Double, Double, Int, String, String) = {
    val lowered = input.toLowerCase
    val gender = lowered match {
      case s if s.contains("male") || s.contains("man") || s.contains("boy") => "male"
      case s if s.contains("female") || s.contains("woman") || s.contains("girl") => "female"
      case _ =>
        def askGenderRec(): String = {
          println("Enter your gender (male/female):")
          val genderInput = readLine().trim.toLowerCase
          genderInput match {
            case s if s.contains("male") || s.contains("man") => "male"
            case s if s.contains("female") || s.contains("woman") => "female"
            case _ =>
              println("Invalid input. Please try again.")
              askGenderRec()
          }
        }
        askGenderRec()
    }
    val weight = lowered.split(" ").toList.sliding(2).collectFirst {
      case List(w, u) if u.contains("kg") || u.contains("kilos") => w.toDouble
    }.getOrElse {
      println("Enter your weight in kg:")
      readDouble()
    }
    val height = lowered.split(" ").toList.sliding(2).collectFirst {
      case List(h, u) if u.contains("cm") || u.contains("centimeter") => h.toDouble
    }.getOrElse {
      println("Enter your height in cm:")
      readDouble()
    }
    val age = lowered.split(" ").toList.sliding(2).collectFirst {
      case List(a, b) if b.contains("year") || b.contains("yrs") => a.toInt
    }.getOrElse {
      println("Enter your age:")
      readInt()
    }
    val activity = lowered match {
      case s if s.contains("highly active") || s.contains("training") => "active"
      case s if s.contains("moderate") || s.contains("medium") => "moderate"
      case s if s.contains("low") || s.contains("sedentary") => "low"
      case _ =>
        println("Enter your activity level (low/moderate/active):")
        readLine().trim.toLowerCase
    }
    val bodyType = lowered match {
      case s if s.contains("ectomorph") => "Ectomorph"
      case s if s.contains("mesomorph") => "Mesomorph"
      case s if s.contains("endomorph") => "Endomorph"
      case _ =>
        println("What's your body type? (ectomorph, mesomorph, endomorph):")
        readLine().trim.capitalize
    }
    (gender, weight, height, age, activity, bodyType)
  }
  def getUserInfo(): (String, Double, Double, Int, String) = {
    println("Enter your gender (male/female):")
    val genderInput = readLine().trim.toLowerCase
    val gender = genderInput match {
      case "male" | "man" | "boy" => "male"
      case "female" | "woman" | "girl" => "female"
      case _ => "unknown"
    }
    println("Enter your weight in kg:")
    val weight = readDouble()
    println("Enter your height in cm:")
    val height = readDouble()
    println("Enter your age:")
    val age = readInt()
    println("Enter activity level (low, moderate, active):")
    val activityInput = readLine().trim.toLowerCase
    val activity = activityInput match {
      case "low" => "low"
      case "moderate" => "moderate"
      case "active" => "active"
      case _ => "moderate"
    }
    (gender, weight, height, age, activity)
  }
  def calculateBMR(gender: String, weight: Double, height: Double, age: Int): Double = gender match {
    case "male" => 10 * weight + 6.25 * height - 5 * age + 5
    case "female" => 10 * weight + 6.25 * height - 5 * age - 161
    case _ => 10 * weight + 6.25 * height - 5 * age + 5
  }
  def calculateWaterIntake(weightKg: Double, activity: String): Double = {
    val baseWater = weightKg * 0.033
    val adjustedWater = activity match {
      case "low" => baseWater
      case "moderate" => baseWater + 0.35
      case "active" => baseWater + 0.7
      case _ => baseWater + 0.35
    }
    println(f"\nYour recommended daily water intake is: $adjustedWater%.2f liters")
    adjustedWater
  }
  def generateDietPlan(targetCalories: Double): Unit = {
    println(s"\n--- Sample Diet Plan (~$targetCalories kcal) ---")
    val meals = List(
      ("Breakfast", 0.25),
      ("Lunch", 0.30),
      ("Dinner", 0.30),
      ("Snacks", 0.15)
    )
    meals.foreach {
      case (meal, ratio) =>
        val kcal = (targetCalories * ratio).toInt
        val grams = kcal / 2.0
        println(s"\n$meal (~$kcal kcal / ~$grams g):")
        val food = meal match {
          case "Breakfast" => "Oats, banana, eggs"
          case "Lunch" => "Chicken breast, rice, steamed vegetables"
          case "Dinner" => "Grilled fish, quinoa, salad"
          case "Snacks" => "Greek yogurt, almonds, protein shake"
        }
        println(s"Foods: $food")
        println(s"Nutrition: Protein ${(kcal * 0.3).toInt}g, Carbs ${(kcal * 0.45).toInt}g, Fats ${(kcal * 0.25).toInt}g")
        println("Vitamins: A, B, C, D complex | Sodium: Moderate")
    }
  }
  def CaloriesForGoal(goal: String, baseCalories: Double): Double = goal.toLowerCase match {
    case "bulk" | "bulking" | "gain" | "increase" | "mass" => baseCalories + 500
    case "cut" | "cutting" | "lose" | "loss" | "shred" => baseCalories - 500
    case _ => baseCalories
  }

  "Handled weight goal successfully"
}
  def generateTrainingPlan(sport: String = "", days: Int = 0): Unit = {
  println("What's your primary fitness goal? (muscle/strength/endurance/athlete/crossfit/fitness/calisthenics):")
  val goalInput = readLine().trim.toLowerCase
  val goal = goalInput match {
    case "muscle" | "muscles" | "bulking" | "muscular" | "mucle" | "muscl" | "muscels" | "muscler" | "musclese" | "musclee" => "muscle"
    case "strength" | "strong" | "power" | "strenght" | "strenth" | "stronng" | "strenthg" | "strangth" | "stregth" | "sthrenght" => "strength"
    case "endurance" | "endurance training" | "stamina" | "endurence" | "endurnace" | "endurace" | "enduranc" | "endurane" | "endurnace" | "stamena" => "endurance"
    case "crossfit" | "cross fit" | "crosfit" | "crossfitt" | "cros-fit" | "crossfittness" | "crossphit" | "xfit" | "crossphitt" => "crossfit"
    case "fitness" | "fitnes" | "fittness" | "fintess" | "fintnes" | "fitniss" | "finess" | "fitnnes" | "fitnesz" | "fitnez" => "fitness"
    case "calisthenics" | "calesthenics" | "calistenics" | "callisthenics" | "callesthenics" | "calisthetics" | "calestinics" | "calisthnics" | "calistheniks" | "bodyweight" => "calisthenics"
    case "athlete" | "athletic" | "athlet" | "athleta" | "athltee" | "athletc" | "athletick" | "athlethe" | "athlte" | "athleticc" |
         "football" | "soccer" | "futbol" | "futboll" | "footbal" | "soccor" | "futball" | "futbol" | "footboll" | "futbbal" |
         "boxing" | "fight" | "boksing" | "boxin" | "boing" | "boks" | "bokxing" | "boxxing" | "baxing" | "buxing" |
         "swimming" | "swim" | "swimmin" | "swimng" | "swing" | "swiming" | "swmiming" | "swimmming" | "swming" | "swimmming" |
         "basketball" | "bb" | "baskitball" | "basball" | "basketbal" | "basball" | "basletball" | "baketball" | "baskteball" | "basktball" |
         "running" | "jogging" | "runing" | "runin" | "runnning" | "runnin" | "runingg" | "jogin" | "runnig" | "runingg" |
         "mma" | "mixed martial arts" | "mixed martial" | "mix martial arts" | "mixe martial arts" | "mixing martial arts" | "mima" | "mixtmartialarts" | "mmma" | "mma fight" |
         "taekwondo" | "tkd" | "taekondo" | "tae kwon do" | "taekwondo" | "taekwon do" | "takwondo" | "tekondo" | "taekwodno" | "taekowndo" |
         "cycling" | "bike" | "biking" | "bicyle" | "bycicle" | "cicle" | "bicycl" | "cyclin" | "bycicling" | "cycing" |
         "karate" | "karatti" | "karat" | "karatye" | "karatte" | "karete" | "karatye" | "krate" | "karatte" | "karatta" => "athlete"
    case _ => "unknown"
  }

  val availableDays = if (days == 0) {
    println("How many days per week can you train? (1–7):")
    val input = readLine().trim.toLowerCase
    input match {
      case "one" | "1" => 1
      case "two" | "2" => 2
      case "three" | "3" => 3
      case "four" | "4" => 4
      case "five" | "5" => 5
      case "six" | "6" => 6
      case "seven" | "7" => 7
      case _ => 3
    }
  } else {
    days.max(1).min(7)
  }

  val cardioRoutine =
    """
❤️ Cardio Routine (Do 3x/week on any non-lifting days or post-training):
- 20 min HIIT cycling or rowing
- 30 min moderate incline treadmill
- Sprint Intervals (6x30s with 90s rest)
"""

  val plan = goal match {
    case "muscle" => generateMusclePlan(availableDays)
    case "strength" => generateStrengthPlan(availableDays)
    case "endurance" => generateEndurancePlan(availableDays)
    case "crossfit" => generateCrossfitPlan(availableDays)
    case "fitness" => generateFitnessPlan(availableDays)
    case "calisthenics" => generateCalisthenicsPlan(availableDays)
    case "athlete" => generateAthletePlan(availableDays)
    case _ => "❌ Invalid goal selected."
  }

  println(s"\n📅 Weekly Training Plan:\n$plan")
  println(cardioRoutine)
}
def generateMusclePlan(days: Int): String = days match {
  case 1 => "Day 1: Full Body Strength + 15 min HIIT\n  - Squats: 4 sets x 8-10 reps\n  - Bench Press: 4 sets x 8-10 reps\n  - Deadlifts: 3 sets x 5 reps\n  - Pull-ups: 3 sets x 8 reps"
  case 2 => "Day 1: Upper Body\n  - Bench Press: 4 sets x 8 reps\n  - Dumbbell Rows: 4 sets x 10 reps\n  - Overhead Press: 3 sets x 8 reps\n  - Bicep Curls: 3 sets x 12 reps\n  - Tricep Dips: 3 sets x 10 reps\nDay 2: Lower Body\n  - Squats: 4 sets x 8 reps\n  - Lunges: 3 sets x 10 reps\n  - Leg Press: 3 sets x 8 reps\n  - Deadlifts: 3 sets x 5 reps\n  - Calf Raises: 3 sets x 12 reps"
  case 3 => "Day 1: Push (Chest/Shoulders/Triceps)\n  - Bench Press: 4 sets x 8 reps\n  - Incline Dumbbell Press: 3 sets x 10 reps\n  - Military Press: 3 sets x 8 reps\n  - Tricep Dips: 3 sets x 10 reps\n  - Lateral Raises: 3 sets x 12 reps\nDay 2: Pull (Back/Biceps)\n  - Pull-ups: 4 sets x 8 reps\n  - Barbell Rows: 3 sets x 8 reps\n  - Bicep Curls: 3 sets x 12 reps\n  - Face Pulls: 3 sets x 12 reps\nDay 3: Legs + Abs\n  - Squats: 4 sets x 8 reps\n  - Deadlifts: 3 sets x 5 reps\n  - Leg Press: 3 sets x 8 reps\n  - Ab Rollouts: 3 sets x 12 reps"
  case 4 => "Push / Pull / Legs / Upper Hypertrophy Split\n  - Day 1: Push (Chest, Shoulders, Triceps)\n  - Day 2: Pull (Back, Biceps)\n  - Day 3: Legs\n  - Day 4: Upper Body (Chest, Back, Shoulders)"
  case 5 => "Push / Pull / Legs / Upper / Lower Split\n  - Day 1: Push\n  - Day 2: Pull\n  - Day 3: Legs\n  - Day 4: Upper Body\n  - Day 5: Lower Body"
  case 6 | 7 => "Classic Bro Split: Day 1: Chest\nDay 2: Back\nDay 3: Legs\nDay 4: Shoulders\nDay 5: Arms\nDay 6: Core + Calisthenics\nDay 7: Rest"
  case _ => "Minimum: 1 day required"
}
def generateStrengthPlan(days: Int): String = days match {
  case 1 => "Day 1: Full Body Strength + 20 min HIIT\n  - Squat: 5 sets x 5 reps\n  - Deadlift: 4 sets x 5 reps\n  - Bench Press: 4 sets x 5 reps\n  - Overhead Press: 3 sets x 6 reps"
  case 2 => "Day 1: Squat Focus + Core\n  - Squats: 5 sets x 5 reps\n  - Front Squats: 4 sets x 6 reps\n  - Planks: 3 sets x 1 min\nDay 2: Deadlift + Push\n  - Deadlifts: 4 sets x 5 reps\n  - Bench Press: 4 sets x 5 reps\n  - Push-ups: 3 sets x 15 reps"
  case 3 => "Day 1: Squat\n  - Squats: 5 sets x 5 reps\n  - Leg Press: 4 sets x 6 reps\n  - Bulgarian Split Squats: 3 sets x 8 reps\nDay 2: Bench Press\n  - Bench Press: 5 sets x 5 reps\n  - Incline Dumbbell Press: 4 sets x 8 reps\n  - Dips: 3 sets x 8 reps\nDay 3: Deadlift\n  - Deadlifts: 5 sets x 5 reps\n  - Barbell Rows: 4 sets x 6 reps\n  - Pull-ups: 3 sets x 6 reps"
  case 4 => "Strength Split: Lower/Upper Strength\n  - Day 1: Lower Body Strength\n  - Day 2: Upper Body Strength"
  case 5 => "Strength Split + Accessory Work\n  - Day 1: Squat Focus\n  - Day 2: Bench Press Focus\n  - Day 3: Deadlift Focus\n  - Day 4: Accessory Upper/Lower Body"
  case 6 | 7 => "Powerlifting Style Split: Squat/Bench/Deadlift Focus with Accessory Movements\n  - Day 1: Squat\n  - Day 2: Bench Press\n  - Day 3: Deadlift\n  - Day 4: Full Body Accessory Movements"
  case _ => "Minimum: 1 day required"
}
def generateEndurancePlan(days: Int): String = days match {
  case 1 => "Day 1: Full-body endurance circuit + 30 min steady-state cardio\n  - Push-ups: 4 sets x 15 reps\n  - Squats: 4 sets x 15 reps\n  - Lunges: 4 sets x 12 reps"
  case 2 => "Day 1: Upper body endurance\n  - Pull-ups: 4 sets x 10 reps\n  - Shoulder Press: 4 sets x 12 reps\n  - Dips: 3 sets x 12 reps\nDay 2: Lower body endurance\n  - Leg Press: 4 sets x 15 reps\n  - Deadlifts: 4 sets x 12 reps\n  - Bulgarian Split Squats: 3 sets x 10 reps"
  case 3 => "Day 1: Push endurance\n  - Push-ups: 4 sets x 20 reps\n  - Overhead Press: 4 sets x 12 reps\n  - Chest Fly: 3 sets x 12 reps\nDay 2: Pull endurance\n  - Pull-ups: 4 sets x 12 reps\n  - Barbell Rows: 4 sets x 10 reps\n  - Bicep Curls: 3 sets x 12 reps\nDay 3: Legs + Core\n  - Squats: 4 sets x 15 reps\n  - Lunges: 4 sets x 12 reps\n  - Planks: 3 sets x 1 min"
  case 4 => "Endurance split: Full-body + HIIT Intervals\n  - Day 1: Full Body Endurance\n  - Day 2: Core + Speed Work"
  case 5 => "Endurance Split + Core + Stamina circuits\n  - Day 1: Full Body Circuit\n  - Day 2: HIIT + Core\n  - Day 3: Strength Endurance"
  case 6 | 7 => "Endurance Plan: Daily full-body circuit + HIIT sprints + Steady-state cardio\n  - 6 days of endurance-based circuit training + sprint intervals"
  case _ => "Minimum: 1 day required"
}
def generateCrossfitPlan(trainingDays: Int): String = {
  trainingDays match {
     case 1 => "CrossFit - 1 Day:\n- Hero WOD (e.g., Murph)\n- Full-body intensity\n- Stretch & recover"
  case 2 => "CrossFit - 2 Days:\nDay 1: Olympic Lifts + Short WOD\nDay 2: Metcon + Core"
  case 3 => "CrossFit - 3 Days:\nDay 1: Strength + WOD\nDay 2: Gymnastics Skills\nDay 3: Chipper + Mobility"
  case 4 => "CrossFit - 4 Days:\nUpper/Lower Splits, Conditioning, and Partner WOD"
  case 5 => "CrossFit - 5 Days:\nPush, Pull, Legs, Metcon, Hero WOD\nBalance intensity"
  case 6 => "CrossFit - 6 Days:\n3 Strength Days + 3 Conditioning Days\nInclude Olympic and Gymnastics"
  case 7 => "CrossFit - 7 Days:\n6 Training Days + 1 Active Recovery\nFocus: Full cycle coverage"
  case _ => "Invalid number of training days for CrossFit. Please enter 1 to 7."
  }
}

def generateFitnessPlan(trainingDays: Int): String = {
  trainingDays match {
    case 1 => "Fitness - 1 Day:\n- Full Body Routine + Cardio\n- Core finisher and stretch"
  case 2 => "Fitness - 2 Days:\nDay 1: Upper Body\nDay 2: Lower Body + Core"
  case 3 => "Fitness - 3 Days:\nPush, Pull, Legs\nOptional Cardio on off days"
  case 4 => "Fitness - 4 Days:\nUpper/Lower Split + HIIT + Functional"
  case 5 => "Fitness - 5 Days:\nPush, Pull, Legs, Cardio, Recovery\nMobility work included"
  case 6 => "Fitness - 6 Days:\nChest, Back, Legs, Shoulders, Arms, Cardio\nInclude stretching"
  case 7 => "Fitness - 7 Days:\n6 Workouts + 1 Yoga/Mobility Day\nBalanced volume & recovery"
  case _ => "Invalid number of training days for Fitness. Please enter 1 to 7."
  }
}

def generateCalisthenicsPlan(trainingDays: Int): String = {
  trainingDays match {
    case 1 => "Calisthenics - 1 Day:\n- Full Body Circuit\n- Push-ups, Pull-ups, Squats, Planks"
  case 2 => "Calisthenics - 2 Days:\nDay 1: Upper Body (Push/Pull)\nDay 2: Legs + Core"
  case 3 => "Calisthenics - 3 Days:\nPush Day, Pull Day, Leg Day\nAdd holds (L-sit, Handstand)"
  case 4 => "Calisthenics - 4 Days:\nSkill Work + Push + Pull + Legs"
  case 5 => "Calisthenics - 5 Days:\n2 Skills Days, 2 Strength Days, 1 Conditioning"
  case 6 => "Calisthenics - 6 Days:\nRepeat Push/Pull/Legs with Progressions\nAdd Static Holds"
  case 7 => "Calisthenics - 7 Days:\nFull Rotation with Handstands, Levers, Planche Practice"
  case _ => "Invalid number of training days for Calisthenics. Please enter 1 to 7."
  }
}

def generateAthletePlan( days: Int=0): String = {
  
    println("Enter your sport (e.g., football, boxing, swimming, basketball, running, mma, taekwondo, etc.):")
    val sportInput = readLine().trim.toLowerCase
  
  val sport = sportInput match{
  case "football" | "soccer" | "futbol" | "futboll" | "footbal" | "soccor" | "futball" | "futbol" | "footboll" | "futbbal" => "football" 
  case "boxing" | "fight" | "boksing" | "boxin" | "boing" | "boks" | "bokxing" | "boxxing" | "baxing" | "buxing" => "boxing" 
  case "swimming" | "swim" | "swimmin" | "swimng" | "swing" | "swiming" | "swmiming" | "swimmming" | "swming" | "swimmming" =>"swimming" 
  case "basketball" | "bb" | "baskitball" | "basball" | "basketbal" | "basball" | "basletball" | "baketball" | "baskteball" | "basktball" => "basketball" 
  case "running" | "jogging" | "runing" | "runin" | "runnning" | "runnin" | "runingg" | "jogin" | "runnig" | "runingg" => "running" 
  case "mma" | "mixed martial arts" | "mixed martial" | "mix martial arts" | "mixe martial arts" | "mixing martial arts" | "mima" | "mixtmartialarts" | "mmma" | "mma fight" => "mma"
  case "taekwondo" | "tkd" | "taekondo" | "tae kwon do" | "taekwondo" | "taekwon do" | "takwondo" | "tekondo" | "taekwodno" | "taekowndo" => "taekwondo" 
  case "cycling" | "bike" | "biking" | "bicyle" | "bycicle" | "cicle" | "bicycl" | "cyclin" | "bycicling" | "cycing" => "cycling"
  case "karate" | "karatti" | "karat" | "karatye" | "karatte" | "karete" | "karatye" | "krate" | "karatte" | "karatta" => "karate" 
  case _ => println("Sorry but this sport isn't found")
}

  sport match {
    case "football" => s"""
      ⚽ Football Athlete Plan ($days days/week):
      - Monday: Sprint Drills + Lower Body Power
      - Tuesday: Ball Control + Agility + Core
      - Wednesday: Strength (Full Body)
      - Thursday: Tactical Practice + Light Run
      - Friday: Plyometrics + Upper Body Strength
      - Saturday: Match Simulation or Team Training
      - Sunday: Recovery and Stretch
      """
    case "boxing" => s"""
      🥊 Boxing Athlete Plan ($days days/week):
      - Monday: Sparring + Speed Drills
      - Tuesday: Strength Training + Bag Work
      - Wednesday: Footwork + Endurance Conditioning
      - Thursday: Heavy Bag + Core
      - Friday: Speed & Agility + Technique
      - Saturday: Full Sparring Session
      - Sunday: Recovery + Active Stretch
      """
    case "swimming" => s"""
      🏊 Swimming Athlete Plan ($days days/week):
      - Monday: Sprint Sets + Technique Drills
      - Tuesday: Distance Laps + Strength Circuit
      - Wednesday: Kickboard & Pull Buoy Work
      - Thursday: IM Sets + Core Training
      - Friday: Race Simulation + Recovery Swim
      - Saturday: Dryland Training + Flexibility
      - Sunday: Rest or Light Swim
      """
    case "basketball" => s"""
      🏀 Basketball Athlete Plan ($days days/week):
      - Monday: Dribbling + Plyometrics
      - Tuesday: Full Body Strength + Jump Training
      - Wednesday: Shooting Drills + Speed Work
      - Thursday: Mobility + Tactical Review
      - Friday: Scrimmage + Agility
      - Saturday: Conditioning + Recovery
      - Sunday: Rest
      """
    case "mma" => s"""
      🥋 MMA Athlete Plan ($days days/week):
      - Monday: Sparring + Strength Training
      - Tuesday: Technique Drills + Cardio Conditioning
      - Wednesday: Grappling + Full Body Strength
      - Thursday: Striking + Agility Training
      - Friday: Endurance Conditioning + Core
      - Saturday: Fight Simulation + Recovery
      - Sunday: Rest or Active Recovery
      """
    case "taekwondo" => s"""
      🥋 Taekwondo Athlete Plan ($days days/week):
      - Monday: Kicking Drills + Strength
      - Tuesday: Flexibility + Plyometrics
      - Wednesday: Speed Drills + Endurance
      - Thursday: Technique Training + Core
      - Friday: Sparring + Power Drills
      - Saturday: Recovery + Mobility
      - Sunday: Rest or Light Training
      """
    case "cycling" => s"""
      🚴 Cycling Athlete Plan ($days days/week):
      - Monday: Sprint Intervals + Leg Strength
      - Tuesday: Distance Ride + Endurance
      - Wednesday: Core Stability + Agility Drills
      - Thursday: Hill Repeats + Speed Work
      - Friday: Recovery Ride + Mobility
      - Saturday: Long Ride (Endurance Focus)
      - Sunday: Rest or Active Recovery
      """
    case "karate" => s"""
      🥋 Karate Athlete Plan ($days days/week):
      - Monday: Kihon (Basics) + Power Training
      - Tuesday: Kata (Forms) + Core Work
      - Wednesday: Kumite (Sparring) + Agility
      - Thursday: Flexibility + Strength
      - Friday: Technique + Reaction Drills
      - Saturday: Light Sparring + Mobility
      - Sunday: Rest or Active Recovery
      """  
    case _ => s"Generic Athlete Plan ($days days/week):\n- Strength\n- Conditioning\n- Sport-specific drills\n- Agility + Recovery"
  }
}
     @main def run(): Unit = {
  def greetUser(): String = {
    "Hi! Want to improve your eating habits or test your nutrition knowledge today?"
  }
val input =readLine()
readMessage( input )
}
