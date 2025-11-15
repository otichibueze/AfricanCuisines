# CLAUDE.md - African Cuisines Android App

## Project Overview

**African Cuisines** is an educational Android application developed as part of the ALC 4.0 Port-Harcourt meet-up 1.0. This is a starter code project designed to teach students Android development fundamentals, particularly focusing on JSON parsing, UI design, and data binding.

### Project Purpose
- Educational/mentoring project for Android development students
- Teaches JSON parsing without using third-party libraries
- Demonstrates activity layout design and data population
- Introduces testing with Espresso

### Application Type
- **Platform**: Android
- **Language**: Java
- **Build System**: Gradle
- **Min SDK**: 16 (Android 4.1 Jelly Bean)
- **Target SDK**: 28 (Android 9.0 Pie)
- **Compile SDK**: 28

## Repository Structure

```
AfricanCuisines/
├── app/
│   ├── src/
│   │   ├── androidTest/          # Instrumented tests
│   │   │   └── java/com/chibusoft/africancuisines/
│   │   │       └── ExampleInstrumentedTest.java
│   │   ├── main/
│   │   │   ├── java/com/chibusoft/africancuisines/
│   │   │   │   ├── MainActivity.java           # List of cuisines
│   │   │   │   ├── DetailActivity.java         # Detail view (incomplete)
│   │   │   │   ├── model/
│   │   │   │   │   └── Cuisine.java            # Data model (incomplete)
│   │   │   │   └── utils/
│   │   │   │       └── jsonUtils.java          # JSON parsing utility
│   │   │   ├── res/
│   │   │   │   ├── layout/
│   │   │   │   │   ├── activity_main.xml       # Main list view
│   │   │   │   │   └── activity_detail.xml     # Detail view (incomplete)
│   │   │   │   ├── values/
│   │   │   │   │   ├── strings.xml             # String resources & JSON data
│   │   │   │   │   ├── colors.xml
│   │   │   │   │   └── styles.xml
│   │   │   │   └── drawable/                   # Icons and drawables
│   │   │   └── AndroidManifest.xml
│   │   └── test/                 # Unit tests
│   │       └── java/com/chibusoft/africancuisines/
│   │           └── ExampleUnitTest.java
│   ├── build.gradle              # App-level Gradle config
│   └── proguard-rules.pro
├── gradle/                       # Gradle wrapper files
├── ScreenShots/                  # App screenshots
├── build.gradle                  # Project-level Gradle config
├── gradle.properties
├── settings.gradle
├── gradlew                       # Gradle wrapper script (Unix)
├── gradlew.bat                   # Gradle wrapper script (Windows)
├── .gitignore
└── README.md
```

## Architecture & Design

### Application Flow
1. **MainActivity** → Displays a ListView of 18 African cuisines
2. User clicks on a cuisine → **DetailActivity** launched with position parameter
3. **DetailActivity** → Fetches JSON data, parses it, and displays cuisine details

### Key Components

#### 1. MainActivity (`MainActivity.java`)
- **Purpose**: Entry point, displays list of African cuisines
- **Key Features**:
  - Loads cuisine names from string array resource (`R.array.Cuisines_names`)
  - Uses ArrayAdapter with simple_list_item_1 layout
  - Launches DetailActivity on item click with position extra

#### 2. DetailActivity (`DetailActivity.java`)
- **Purpose**: Display detailed information about selected cuisine
- **Status**: INCOMPLETE - Contains TODO markers for students
- **Missing Implementation**:
  - TextView field declarations for UI elements
  - findViewById() calls for UI binding
  - Picasso image loading integration

#### 3. Cuisine Model (`model/Cuisine.java`)
- **Purpose**: Data model for cuisine objects
- **Status**: INCOMPLETE - Contains TODO markers
- **Fields**:
  - `String mainName` - Name of the cuisine
  - `String placeOfOrigin` - Origin location
  - `String description` - Detailed description
  - `String image` - URL to cuisine image
  - `List<String> ingredients` - List of ingredients
- **Missing Implementation**:
  - Parameterized constructor
  - Getter and setter methods

#### 4. JSON Utilities (`utils/jsonUtils.java`)
- **Purpose**: Parse JSON strings into Cuisine objects
- **Status**: PARTIALLY COMPLETE
- **Implementation**:
  - Parses JSON with structure: `{"name": {"mainName": "..."}, "placeOfOrigin": "...", "description": "...", "image": "...", "ingredients": [...]}`
  - Extracts all fields correctly
  - **Missing**: Object instantiation (needs Cuisine constructor)
- **Note**: Uses manual JSON parsing (org.json.JSONObject) for educational purposes

### Data Source

All cuisine data is stored in `res/values/strings.xml` as a string array:
- **Array Name**: `Cuisines_names` (18 cuisine names)
- **Array Name**: `Cuisines_details` (18 JSON strings with complete cuisine data)

**Cuisines Included**:
1. Oha soup (Nigeria)
2. Ogbono soup (Nigeria)
3. Afang Soup (Nigeria)
4. Àmàlà (West Africa)
5. Banga soup (Nigeria)
6. Jollof rice (West Africa)
7. Kuli-kuli (West Africa)
8. Edikang Ikong (Nigeria)
9. Feijoada (East Africa)
10. Isi ewu (Nigeria)
11. Akara (West Africa)
12. Suya (Nigeria)
13. Tomato bredie (South Africa)
14. Brik (Tunisia)
15. Kushari (Egypt)
16. Egusi soup (West Africa)
17. Ugali (South Africa/Zimbabwe)
18. Lablabi (Tunisia)

## Dependencies

### Current Dependencies (`app/build.gradle`)
```gradle
implementation 'com.android.support:appcompat-v7:28.0.0'
implementation 'com.android.support.constraint:constraint-layout:1.1.3'
testImplementation 'junit:junit:4.12'
androidTestImplementation 'com.android.support.test:runner:1.0.2'
androidTestImplementation 'com.android.support.test.espresso:espresso-core:3.0.2'
```

### Required Dependencies (TODO)
```gradle
// Picasso for image loading - NOT YET ADDED
// Students need to add from: http://square.github.io/picasso/
implementation 'com.squareup.picasso:picasso:2.71828'
```

## Development Workflow

### Building the Project
```bash
# Build debug APK
./gradlew assembleDebug

# Build release APK
./gradlew assembleRelease

# Install on connected device
./gradlew installDebug
```

### Running Tests
```bash
# Run unit tests
./gradlew test

# Run instrumented tests (requires device/emulator)
./gradlew connectedAndroidTest
```

### Cleaning Build
```bash
./gradlew clean
```

## Coding Conventions & Patterns

### Package Structure
- **Base Package**: `com.chibusoft.africancuisines`
- **Model Package**: `com.chibusoft.africancuisines.model` (data classes)
- **Utils Package**: `com.chibusoft.africancuisines.utils` (helper classes)

### Naming Conventions

#### Java Files
- **Activities**: `<Name>Activity.java` (e.g., `MainActivity.java`, `DetailActivity.java`)
- **Models**: Singular noun (e.g., `Cuisine.java`)
- **Utils**: Lowercase with "Utils" suffix (e.g., `jsonUtils.java`) - *Note: Should be `JsonUtils` per Java conventions*

#### Variables
- **Member Variables**: Prefix with `m` (e.g., `mPlaceOfOrigin`, `mDescription`)
- **Static Variables**: All caps with underscores (e.g., `EXTRA_POSITION`, `DEFAULT_POSITION`)
- **Local Variables**: camelCase (e.g., `position`, `cuisine`, `json`)

#### Resources
- **IDs**: snake_case with type suffix (e.g., `cuisines_listview`, `image_iv`, `origin_tv`)
- **Layouts**: `activity_<name>.xml` (e.g., `activity_main.xml`)
- **Strings**: snake_case (e.g., `detail_error_message`)

### Code Style
- **Indentation**: Standard Android Studio (4 spaces)
- **Braces**: K&R style (opening brace on same line)
- **Access Modifiers**: Explicit (always use public/private/protected)
- **Error Handling**: Toast messages for user-facing errors

## Outstanding TODOs

### High Priority (Core Functionality)

#### 1. Cuisine.java
```java
// Line 19: Create parameterized constructor
public Cuisine(String mainName, String placeOfOrigin, String description,
               String image, List<String> ingredients)

// Line 22: Add getters and setters for all fields
public String getMainName() { return mainName; }
public void setMainName(String mainName) { this.mainName = mainName; }
// ... (repeat for all fields)
```

#### 2. jsonUtils.java
```java
// Line 42: Instantiate Cuisine object with parsed data
cuisines = new Cuisine(mainName, placeOfOrigin, description, image, ingredients);
```

#### 3. DetailActivity.java
```java
// Lines 21-25: Declare TextView fields
private TextView mOriginDetails;
private TextView mDescription;
private TextView mDescriptionDetails;
private TextView mIngredients;
private TextView mIngredientsDetails;

// Lines 57-61: Initialize TextViews
mOriginDetails = findViewById(R.id.origin_details);
mDescription = findViewById(R.id.description_tv);
// ... etc.

// Lines 77-84: Populate UI in populateUI() method
mOriginDetails.setText(cuisine.getPlaceOfOrigin());
mDescriptionDetails.setText(cuisine.getDescription());

StringBuilder s = new StringBuilder();
for (String ingredient : cuisine.getIngredients()) {
    s.append(ingredient).append(", ");
}
mIngredientsDetails.setText(s.substring(0, s.length() - 2));

// Line 65: Add Picasso image loading
Picasso.get().load(cuisine.getImage()).into(ingredientsIv);
```

#### 4. activity_detail.xml
```xml
<!-- Lines 13-20: Add complete layout structure -->
<LinearLayout
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">

    <ImageView
        android:id="@+id/image_iv"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:contentDescription="@string/cuisines_picture_content_description" />

    <TextView
        android:id="@+id/origin_lb"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="@string/detail_place_of_origin_label" />

    <!-- Add remaining TextViews for origin_details, description_tv,
         description_details, ingredients_tv, ingredients_details -->
</LinearLayout>
```

#### 5. AndroidManifest.xml
```xml
<!-- Line 5: Add internet permission -->
<uses-permission android:name="android.permission.INTERNET" />
```

#### 6. app/build.gradle
```gradle
// Line 28: Add Picasso dependency
implementation 'com.squareup.picasso:picasso:2.71828'
```

## Testing Strategy

### Unit Tests (`app/src/test`)
- **File**: `ExampleUnitTest.java`
- **Purpose**: Test business logic and utilities
- **Recommended Tests**:
  - JSON parsing with valid data
  - JSON parsing with invalid/malformed data
  - Cuisine model getters/setters

### Instrumented Tests (`app/src/androidTest`)
- **File**: `ExampleInstrumentedTest.java`
- **Purpose**: Test UI and Android-specific functionality
- **Framework**: Espresso
- **Recommended Tests**:
  - ListView populates with correct number of items
  - Clicking a cuisine launches DetailActivity
  - DetailActivity displays correct data
  - Error handling when JSON is malformed

## Git Workflow

### Branch Structure
- **Main Branch**: `master` (contains starter code with TODOs)
- **Complete Branch**: `AfricanCuisineComplete` (contains completed implementation)

### Commit Message Conventions
- Use descriptive commit messages
- Reference TODOs when completing them
- Example: "Add Cuisine model constructor and getters/setters"

## Common Issues & Solutions

### Issue 1: JSON Parsing Returns Null
**Cause**: Cuisine constructor not implemented
**Solution**: Complete TODO in `Cuisine.java` and `jsonUtils.java`

### Issue 2: Images Not Loading
**Causes**:
1. Picasso library not added to dependencies
2. Internet permission not declared in manifest
3. Image loading code not implemented

**Solutions**:
1. Add Picasso to `app/build.gradle`
2. Add `<uses-permission android:name="android.permission.INTERNET" />` to manifest
3. Implement Picasso.get().load().into() in DetailActivity

### Issue 3: DetailActivity Crashes on Launch
**Cause**: TextView fields not initialized with findViewById()
**Solution**: Complete TODOs in DetailActivity.onCreate()

### Issue 4: Blank Detail Screen
**Causes**:
1. UI elements not added to layout XML
2. populateUI() not fully implemented

**Solutions**:
1. Complete TODOs in `activity_detail.xml`
2. Complete TODOs in `DetailActivity.populateUI()`

## AI Assistant Guidelines

### When Working on This Repository

1. **Understand Project Context**
   - This is a learning project with intentional TODOs
   - Students should complete TODOs to learn Android development
   - Don't just fix everything - explain the learning objectives

2. **Code Completion Approach**
   - Reference specific TODO comments when making changes
   - Follow existing naming conventions (member variable prefix `m`, etc.)
   - Use Support Library components (not AndroidX) as project uses SDK 28 with Support Library
   - Match the code style of existing files

3. **Testing Recommendations**
   - Build and test after completing related TODOs
   - Verify JSON parsing works with sample data from strings.xml
   - Test error handling (invalid position, null JSON, etc.)

4. **Common Requests**

   **"Complete the Cuisine model"**
   - Add parameterized constructor with all 5 fields
   - Add getter and setter for each field
   - Follow Java Bean conventions

   **"Implement JSON parsing"**
   - The parsing logic exists; just instantiate Cuisine object
   - Pass extracted variables to Cuisine constructor

   **"Complete DetailActivity"**
   - Declare all TextView member variables
   - Initialize with findViewById in onCreate()
   - Implement populateUI() to set text values
   - Add Picasso for image loading

   **"Complete the layout"**
   - Add LinearLayout wrapper
   - Add ImageView for cuisine image
   - Add TextViews for labels and data
   - Use proper IDs matching Java code

5. **Dependency Management**
   - When adding Picasso, use version 2.71828 or latest stable
   - Don't migrate to AndroidX (project uses Support Library)
   - Keep minSdkVersion at 16 for backward compatibility

6. **Code Quality Checks**
   - Ensure proper error handling (null checks)
   - Add appropriate content descriptions for accessibility
   - Follow Android resource naming conventions
   - Use string resources instead of hardcoded strings

### File Modification Priority

When asked to "complete the app", follow this order:

1. **Cuisine.java** - Add constructor, getters, setters
2. **jsonUtils.java** - Instantiate Cuisine object
3. **app/build.gradle** - Add Picasso dependency
4. **AndroidManifest.xml** - Add internet permission
5. **activity_detail.xml** - Add layout structure and views
6. **DetailActivity.java** - Declare fields, initialize views, populate UI

### Build and Test Commands

Always verify changes with:
```bash
# Sync Gradle files
./gradlew build

# Run on connected device/emulator
./gradlew installDebug

# Run tests
./gradlew test
./gradlew connectedAndroidTest
```

## Additional Resources

### Official Documentation
- [Android Developer Guides](https://developer.android.com/guide)
- [Picasso Library](http://square.github.io/picasso/)
- [Espresso Testing](https://developer.android.com/training/testing/espresso)

### JSON Structure Reference
```json
{
  "name": {
    "mainName": "Oha Soup"
  },
  "placeOfOrigin": "Nigeria, Igbo",
  "description": "Ora (Oha) soup is native to...",
  "image": "https://img-global.cpcdn.com/...",
  "ingredients": [
    "Vegetable Ora leaves",
    "cocoyam",
    "Red Palm Oil",
    ...
  ]
}
```

## License

```
Copyright 2018 Chibusoft, Inc.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

---

**Last Updated**: 2025-11-15
**Repository**: https://github.com/otichibueze/AfricanCuisines
**Maintainer**: Chibusoft, Inc.
