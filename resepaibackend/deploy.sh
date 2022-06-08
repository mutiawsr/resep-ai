GOOGLE_PROJECT_ID=<?>
CLOUD_RUN_SERVICE=mobile-backend-login-register
INSTANCE_CONNECTION_NAME=<?>
DB_USER=<?>
DB_PASS=<?>
DB_NAME=<?>

gcloud run deploy $CLOUD_RUN_SERVICE \
 --image gcr.io/$GOOGLE_PROJECT_ID/$CLOUD_RUN_SERVICE \
 --add-cloudsql-instances $INSTANCE_CONNECTION_NAME \
 --update-env-vars INSTANCE_CONNECTION_NAME=$INSTANCE_CONNECTION_NAME,DB_PASS=$DB_PASS,DB_USER=$DB_USER,DB_NAME=$DB_NAME \
 --platform managed \
 --region asia-southeast2 \
 --allow-unauthenticated \
 --project=$GOOGLE_PROJECT_ID