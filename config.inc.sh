#paths
CLASSES_PATH="classes"
SOURCE_PATH="src"

# term colors
RED="\E[1;31m"
GREEN="\E[1;32m"
YELLOW="\E1;33m"
BLUE="\E[1;34m"
NORMAL="\E[0m"

# messages
function error {
  echo -e "${RED}Error: ${NORMAL}$1"
  exit 1
}

function notice {
  echo -e "${BLUE}$1${NORMAL}"
}

function success {
  echo -e "${GREEN}Success: ${NORMAL}$1"
}

function warning {
  echo -e "${YELLOW}Warning: ${NORMAL}$1"
}
