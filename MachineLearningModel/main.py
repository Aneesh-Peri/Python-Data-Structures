import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.linear_model import LinearRegression, LogisticRegression
from sklearn.metrics import accuracy_score
from sklearn.preprocessing import StandardScaler

# Step 1: Load and preprocess the data
data = pd.read_csv('diabetes2.csv')

# Assuming the last column is the target variable and the rest are features
X = data.iloc[:, :1]  # Features (all columns except the last)
y = data.iloc[:, 1]   # Target variable (last column)

# Step 2: Split the data into train and test sets
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

# Step 3: Standardize the features
scaler = StandardScaler()
X_train_scaled = scaler.fit_transform(X_train)
X_test_scaled = scaler.transform(X_test)

# Step 4: Create and train the logistic regression model with some modifications
# We will add 'class_weight' parameter to handle class imbalance
model = LogisticRegression(solver='newton-cg', random_state=42)
model.fit(X_train_scaled, y_train)

# Step 5: Evaluate the model
y_pred = model.predict(X_test_scaled)

accuracy = accuracy_score(y_test, y_pred)
for prediction in y_pred:
    if(prediction==0):
        print("No Diabetes")
    else:
        print("Diabetes")
print("Accuracy:", (str)(accuracy*100)+"%")


